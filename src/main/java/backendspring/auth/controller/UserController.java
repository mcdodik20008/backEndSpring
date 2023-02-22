package backendspring.auth.controller;

import backendspring.auth.model.entity.User;
import backendspring.auth.model.view.UserViewCreate;
import backendspring.auth.model.view.UserViewRead;
import backendspring.auth.service.UserService;
import backendspring.domain.category.model.entity.Category;
import backendspring.infrasructure.filter.Filter;
import backendspring.infrasructure.filter.FilterToBooleanExpressionMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = "/auth-user", produces = "application/json")
public class UserController {

    FilterToBooleanExpressionMapper<Category> filterMapper;

    UserService service;

    @PostMapping(path = "/login")
    public @ResponseBody User getAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        User user = (principal instanceof User) ? (User) principal : null;
        return Objects.nonNull(user) ? this.service.getByLogin(user.getLogin()) : null;
    }

    @GetMapping
    public Page<UserViewRead> getPage(Filter filter, Pageable pageable) throws NoSuchFieldException {
        var exp = filterMapper.toBooleanExpression(filter);
        return service.getCategories(exp, pageable);
    }

    @GetMapping("/{id}")
    public UserViewRead getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public UserViewRead create(@RequestBody UserViewCreate view) {
        Long id = service.create(view);
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public UserViewRead update(@PathVariable Long id, @RequestBody UserViewCreate view) {
        service.update(id, view);
        return service.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}