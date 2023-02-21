package backendspring.domain.category.controller;

import backendspring.domain.category.model.entity.Category;
import backendspring.domain.category.model.view.CategoryViewCreate;
import backendspring.domain.category.model.view.CategodyViewRead;
import backendspring.domain.category.service.CategoryService;
import backendspring.infrasructure.filter.Filter;
import backendspring.infrasructure.filter.FilterToBooleanExpressionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/categories", produces = "application/json")
public class CategoryController {

    private final FilterToBooleanExpressionMapper filterMapper;

    private final CategoryService service;

    @GetMapping
    public Page<CategodyViewRead> getPage(Filter filter, Pageable pageable) {
        var exp = filterMapper.toBooleanExpression(filter, Category.class);
        return service.getCategories(exp, pageable);
    }

    @GetMapping("/{id}")
    public CategodyViewRead getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public CategodyViewRead create(@RequestBody CategoryViewCreate view) {
        Long id = service.create(view);
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public CategodyViewRead update(@PathVariable Long id, @RequestBody CategoryViewCreate view) {
        service.update(id, view);
        return service.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}