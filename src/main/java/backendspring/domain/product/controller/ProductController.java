package backendspring.domain.product.controller;

import backendspring.domain.product.model.entity.Product;
import backendspring.domain.product.model.view.ProductViewCreate;
import backendspring.domain.product.model.view.ProductViewRead;
import backendspring.domain.product.service.ProductService;
import backendspring.infrasructure.filter.FilterToBooleanExpressionMapper;
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

    FilterToBooleanExpressionMapper<Product> filterMapper;

    ProductService service;

    @GetMapping
    public Page<ProductViewRead> getPage(@RequestParam(required = false) String name, Pageable pageable) {
        return service.getProducts(name, pageable);
    }

    @GetMapping("category/{categoryId}")
    public Page<ProductViewRead> getPage(@PathVariable Long categoryId, Pageable pageable) {
        return service.getProductsByCategory(categoryId, pageable);
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

    @PutMapping("/{id}")
    public ProductViewRead update(@PathVariable Long id, @RequestBody ProductViewCreate view) {
        service.update(id, view);
        return service.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
