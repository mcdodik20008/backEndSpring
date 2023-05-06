package backendspring.domain.product.controller;

import backendspring.domain.product.model.view.ProductViewCreate;
import backendspring.domain.product.model.view.ProductViewRead;
import backendspring.domain.product.model.view.ProductViewUpdate;
import backendspring.domain.product.service.ProductService;
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
@RequestMapping(value = "/products", produces = "application/json")
public class ProductController {

    ProductService service;

    @GetMapping
    public Page<ProductViewRead> getPage(@RequestParam(required = false) String name, Pageable pageable) {
        return service.getProducts(name, pageable);
    }

    @GetMapping("category/{categoryId}")
    public Page<ProductViewRead> getPageWithCategories(@PathVariable Long categoryId, Pageable pageable) {
        return service.getProductsByCategory(categoryId, pageable);
    }

    @GetMapping("subcategories/{subcategoryId}")
    public Page<ProductViewRead> getPageWithSubCategories(@PathVariable Long subcategoryId, Pageable pageable) {
        return service.getProductsBySubCategory(subcategoryId, pageable);
    }

    @GetMapping("/{id}")
    public ProductViewRead getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public ProductViewRead create(@RequestBody ProductViewCreate view) {
        Long id = service.create(view);
        return service.getOne(id);
    }

    @PutMapping("/{productId}")
    public ProductViewRead update(@PathVariable Long productId, Long subCategoryId, @RequestBody ProductViewUpdate view) {
        service.update(productId, subCategoryId, view);
        return service.getOne(productId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
