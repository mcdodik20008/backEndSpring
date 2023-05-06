package backendspring.domain.subcategory.controller;

import backendspring.domain.subcategory.model.view.SubCategoryViewCreate;
import backendspring.domain.subcategory.model.view.SubCategoryViewRead;
import backendspring.domain.subcategory.service.SubCategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = "/subcategories", produces = "application/json")
public class SubCategoryController {

    SubCategoryService service;

    @GetMapping
    public Page<SubCategoryViewRead> getPage(Pageable pageable) {
        return service.getSubCategories(pageable);
    }

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