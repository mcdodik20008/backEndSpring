package backendspring.domain.user.controller;

import backendspring.domain.category.model.entity.Category;
import backendspring.domain.user.model.entity.User;
import backendspring.domain.user.service.UserService;
import backendspring.infrasructure.filter.FilterToBooleanExpressionMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

    FilterToBooleanExpressionMapper<Category> filterMapper;

    UserService service;

    @GetMapping
    public Page<User> getPage(Pageable pageable) throws NoSuchFieldException {
        return service.getPage(pageable);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public User create(@RequestBody User view) {
        Long id = service.create(view);
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User view) {
        service.update(id, view);
        return service.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}