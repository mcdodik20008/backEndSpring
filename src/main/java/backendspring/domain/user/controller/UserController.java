package backendspring.domain.user.controller;

import backendspring.domain.category.model.entity.Category;
import backendspring.domain.category.model.view.CategoryViewCreate;
import backendspring.domain.category.model.view.CategoryViewRead;
import backendspring.domain.category.service.CategoryService;
import backendspring.infrasructure.filter.Filter;
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

    CategoryService service;

    @GetMapping
    public Page<CategoryViewRead> getPage(Filter filter, Pageable pageable) throws NoSuchFieldException {
        var exp = filterMapper.toBooleanExpression(filter);
        return service.getCategories(exp, pageable);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public CategoryViewRead getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public CategoryViewRead create(@RequestBody CategoryViewCreate view) {
        Long id = service.create(view);
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public CategoryViewRead update(@PathVariable Long id, @RequestBody CategoryViewCreate view) {
        service.update(id, view);
        return service.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}