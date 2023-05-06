package backendspring.domain.userorder.controller;


import backendspring.domain.userorder.model.entity.OrderStatus;
import backendspring.domain.userorder.model.view.UserOrderViewCreate;
import backendspring.domain.userorder.model.view.UserOrderViewRead;
import backendspring.domain.userorder.model.view.UserOrderViewUpdate;
import backendspring.domain.userorder.service.UserOrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = "/user-order", produces = "application/json")
public class UserOrderController {

    UserOrderService service;

    @GetMapping("/{userId}")
    public List<UserOrderViewRead> getList(@PathVariable Long userId) {
        return service.getList(userId);
    }

    @GetMapping("/last/{userId}")
    public UserOrderViewRead getLast(@PathVariable Long userId) {
        return service.getLastOrder(userId);
    }

    @GetMapping("/{userId}/{id}") // тут лучше было бы как-то разделить {id}/user/{userId}
    public UserOrderViewRead getOne(@PathVariable Long userId, @PathVariable Long id) {
        return service.getOne(userId, id);
    }

    @GetMapping("/delivery-point/{id}")
    public List<UserOrderViewRead> getOne(@PathVariable Long id) {
        return service.getListByDeliveryPointId(id);
    }

    @PostMapping("/{userId}")
    public UserOrderViewRead create(@PathVariable Long userId, @RequestBody UserOrderViewCreate view) {
        Long id = service.create(userId, view);
        return service.getOne(userId, id);
    }

    @PatchMapping("/{userId}/order/{orderId}")
    public UserOrderViewRead patchStatus(@PathVariable Long userId, @PathVariable Long orderId, @RequestBody OrderStatus orderStatus) {
        Long id = service.patchStatus(userId, orderId, orderStatus);
        return service.getOne(userId, id);
    }

    @PatchMapping("/{userId}/order/{orderId}/{deliveryPointId}") // тут тоже нет разделения id
    public UserOrderViewRead patchDeliveryPoint(@PathVariable Long userId, @PathVariable Long orderId, @PathVariable Long deliveryPointId) {
        Long id = service.patchDeliveryPoint(orderId, deliveryPointId);
        return service.getOne(userId, id);
    }

    @PutMapping("/{userId}/{id}") // тут тоже нет разделения id
    public UserOrderViewRead update(
            @PathVariable Long userId,
            @PathVariable Long id,
            @RequestBody UserOrderViewUpdate view
    ) {
        service.update(userId, id, view);
        return service.getOne(userId, id);
    }

    @DeleteMapping("/{userId}/{id}") // и тут нет разделения id словом
    public void deleteById(@PathVariable Long userId, @PathVariable Long id) {
        service.deleteById(userId, id);
    }
}
