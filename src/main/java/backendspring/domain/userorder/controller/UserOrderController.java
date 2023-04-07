package backendspring.domain.userorder.controller;


import backendspring.domain.userorder.model.entity.OrderStatus;
import backendspring.domain.userorder.model.view.UserOrderViewCreate;
import backendspring.domain.userorder.model.view.UserOrderViewRead;
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
@RequestMapping(value = "/user-order/{userId}", produces = "application/json")
public class UserOrderController {

    UserOrderService service;

    @GetMapping
    public List<UserOrderViewRead> getList(@PathVariable Long userId) {
        return service.getList(userId);
    }

    @GetMapping("/last")
    public UserOrderViewRead getLast(@PathVariable Long userId) {
        return service.getLastOrder(userId);
    }

    @GetMapping("/{id}")
    public UserOrderViewRead getOne(@PathVariable Long userId, @PathVariable Long id) {
        return service.getOne(userId, id);
    }

    @PostMapping
    public UserOrderViewRead create(@PathVariable Long userId, @RequestBody UserOrderViewCreate view) {
        Long id = service.create(userId, view);
        return service.getOne(userId, id);
    }

    @PatchMapping("order/{orderId}")
    public UserOrderViewRead patchStatus(@PathVariable Long userId, @PathVariable Long orderId, @RequestBody OrderStatus orderStatus) {
        Long id = service.patchStatus(userId, orderId, orderStatus);
        return service.getOne(userId, id);
    }

    @PutMapping("/{id}")
    public UserOrderViewRead update(
            @PathVariable Long userId,
            @PathVariable Long id,
            @RequestBody UserOrderViewCreate view
    ) {
        service.update(userId, id, view);
        return service.getOne(userId, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long userId, @PathVariable Long id) {
        service.deleteById(userId, id);
    }
}
