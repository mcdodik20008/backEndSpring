package backendspring.domain.userorder.service;

import backendspring.domain.userorder.model.entity.OrderStatus;
import backendspring.domain.userorder.model.entity.UserOrder;
import backendspring.domain.userorder.model.mapper.ProductMapper;
import backendspring.domain.userorder.model.view.UserOrderViewCreate;
import backendspring.domain.userorder.model.view.UserOrderViewRead;
import backendspring.domain.userorder.repository.ProductOrderRepository;
import backendspring.domain.userorder.repository.UserOrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserOrderService {

    UserOrderRepository repository;

    ProductOrderRepository productOrderRepository;

//    UserService userService;

    ProductMapper mapper = ProductMapper.INSTANCE;
//    private final UserRepository userRepository;

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

    public Long create(Long userId, UserOrderViewCreate view) {
        var entity = mapper.fromViewCreate(view);
        entity.setProductOrder(productOrderRepository.saveAll(entity.getProductOrder()));
        productOrderRepository.flush();
//        entity.setUser(userService.getObject(userId));
        entity = repository.save(entity);
        repository.flush();
        return entity.getId();
    }

    public void update(Long userId, Long id, UserOrderViewCreate view) {
        var entity = getObject(id);
        if (entity.getUser().getId() != userId)
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
        if(OrderStatus.DONE.equals(orderStatus)){
//            User user = userRepository.findById(userId).get();
//            UserOrder order = repository.findById(orderId).get();
//            user.getUserRoom().setBonusPoints(user.getUserRoom().getBonusPoints() + (int) (order.getSum() / 100));
//            userRepository.save(user);
        }
        return 0L;
    }
}
