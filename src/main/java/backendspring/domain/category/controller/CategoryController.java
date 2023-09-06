package backendspring.domain.category.controller;

import backendspring.domain.category.model.view.CategoryViewRead;
import backendspring.domain.category.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = "/", produces = "application/json")
public class CategoryController {

    CategoryService service;

    @GetMapping
    public Page<CategoryViewRead> getPage(Pageable pageable) throws Exception {
        return service.getCategories(pageable);
    }

}