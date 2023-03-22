package backendspring.domain.subcategory.controller;

import backendspring.domain.subcategory.model.entity.SubCategory;
import backendspring.domain.subcategory.model.view.SubCategoryViewCreate;
import backendspring.domain.subcategory.model.view.SubCategoryViewRead;
import backendspring.domain.subcategory.service.SubCategoryService;
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
@RequestMapping(value = "/subcategories", produces = "application/json")
public class SubCategoryController {

    FilterToBooleanExpressionMapper<SubCategory> filterMapper;

    SubCategoryService service;


    @GetMapping
    public Page<SubCategoryViewRead> getPage(Filter filter, Pageable pageable) throws NoSuchFieldException {
        var exp = filterMapper.toBooleanExpression(filter);
        return service.getCategories(exp, pageable);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public SubCategoryViewRead getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public SubCategoryViewRead create(@RequestBody SubCategoryViewCreate view) {
        Long id = service.create(view);
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public SubCategoryViewRead update(@PathVariable Long id, @RequestBody SubCategoryViewCreate view) {
        service.update(id, view);
        return service.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}