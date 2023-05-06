package backendspring.domain.userorder.service;

import backendspring.domain.auth.model.entity.User;
import backendspring.domain.auth.repository.UserRepository;
import backendspring.domain.auth.service.UserService;
import backendspring.domain.point.model.entity.DeliveryPoint;
import backendspring.domain.point.service.DeliveryPointService;
import backendspring.domain.userorder.model.entity.OrderStatus;
import backendspring.domain.userorder.model.entity.UserOrder;
import backendspring.domain.userorder.model.mapper.ProductMapper;
import backendspring.domain.userorder.model.view.UserOrderViewCreate;
import backendspring.domain.userorder.model.view.UserOrderViewRead;
import backendspring.domain.userorder.model.view.UserOrderViewUpdate;
import backendspring.domain.userorder.repository.ProductOrderRepository;
import backendspring.domain.userorder.repository.UserOrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserOrderService {

    UserOrderRepository repository;

    ProductOrderRepository productOrderRepository;

    UserService userService;

    DeliveryPointService deliveryPointService;

    ProductMapper mapper = ProductMapper.INSTANCE;
    private final UserRepository userRepository;

    public List<UserOrderViewRead> getList(Long userId) {
        return repository.findByUserIdOrderByOrderDateTime(userId).stream().map(mapper::toViewRead).toList();
    }

    public UserOrderViewRead getLastOrder(Long userId) {
        var order = repository.findTopByUserIdOrderByOrderDateTimeDesc(userId);
        return mapper.toViewRead(order);
    }

    public UserOrderViewRead getOne(Long userId, Long id) {
        var order = repository.findByUserIdAndId(userId, id);
        return mapper.toViewRead(order);
    }

    public List<UserOrderViewRead> getListByDeliveryPointId(Long id) {
        var orders = repository.findByDeliveryPointId(id).stream().map(mapper::toViewRead).toList();
        if (!orders.isEmpty()) {
            return orders;
        }
        throw new ResponseStatusException(
                NOT_FOUND,
                "Не найдены заказы, доставленные в точку с идентификатором " + id);
    }

    public Long create(Long userId, UserOrderViewCreate view) {
        var entity = mapper.fromViewCreate(view);
        entity.setProductOrder(productOrderRepository.saveAll(entity.getProductOrder()));
        productOrderRepository.flush();
        entity.setUser(userService.getObject(userId));
        entity.setStatus(OrderStatus.IN_PROGRESS);
        entity = repository.save(entity);
        repository.flush();
        return entity.getId();
    }

    public void update(Long userId, Long id, UserOrderViewUpdate view) {
        var entity = getObject(id);
        if (!entity.getUser().getId().equals(userId))
            throw new RuntimeException("Ошибка!");
        mapper.fromViewCreate(entity, view);
        repository.save(entity);
    }

    public void deleteById(Long userId, Long id) {
        if (!getObject(id).getUser().getId().equals(userId)) {
            throw new RuntimeException("Ошибка!");
        }
        repository.deleteById(id);
    }

    private UserOrder getObject(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Не найден заказ с идентификатором " + id));
    }

    public Long patchStatus(Long userId, Long orderId, OrderStatus orderStatus) {
        UserOrder order = repository.findById(orderId).get();
        if (OrderStatus.DONE.equals(orderStatus)) {
            User user = userRepository.findById(userId).get();
            user.getUserRoom().setBonusPoints(user.getUserRoom().getBonusPoints() + (int) (order.getSum() / 100));
            userRepository.save(user);
            userRepository.flush();
            order.setReceiptDate(LocalDate.now());
        }
        order.setStatus(orderStatus);
        repository.save(order);
        return 0L;
    }

    public Long patchDeliveryPoint(Long orderId, Long deliveryPointId) {
        DeliveryPoint dp = deliveryPointService.getOne(deliveryPointId);
        UserOrder order = repository.findById(orderId).get();
        order.setDeliveryPoint(dp);
        repository.save(order);
        return 0L;
    }
}
