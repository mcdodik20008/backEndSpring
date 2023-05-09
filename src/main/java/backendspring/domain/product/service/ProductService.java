package backendspring.domain.product.service;

import backendspring.domain.product.model.entity.Product;
import backendspring.domain.product.model.mapper.ProductMapper;
import backendspring.domain.product.model.view.ProductViewCreate;
import backendspring.domain.product.model.view.ProductViewRead;
import backendspring.domain.product.model.view.ProductViewUpdate;
import backendspring.domain.product.repository.ProductRepository;
import backendspring.domain.subcategory.model.entity.SubCategory;
import backendspring.domain.subcategory.repository.SubCategoryRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {

    ProductRepository repository;

    SubCategoryRepository subCategoryRepository;

    ProductMapper mapper = ProductMapper.INSTANCE;

    public Page<ProductViewRead> getProducts(String name, Pageable pageable) {
        if (name == null || name.equals("null")) {
            return repository.findAll(pageable).map(mapper::toViewRead);
        }
        BooleanExpression exp = QProduct.product.name.startsWith(name);
        return repository.findAll(exp, pageable).map(mapper::toViewRead);
    }

    public ProductViewRead getOne(Long id) {
        return mapper.toViewRead(getObject(id));
    }

    public Long create(ProductViewCreate view) {
        var entity = mapper.fromViewCreate(view);
        return repository.save(entity).getId();
    }

    public void update(Long productId, ProductViewUpdate view) {
        var subId = view.getSubCategory().getId();
        SubCategory subCat = subCategoryRepository.findById(subId).orElseThrow();
        var entity = mapper.fromViewUpdate(getObject(productId), view);
        entity.setSubCategory(subCat);
        repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private Product getObject(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Не найден продукт с идентификатором " + id));
    }

    public Page<ProductViewRead> getProductsByCategory(Long categoryId, Pageable pageable) {
        if (categoryId == null) {
            return repository.findAll(pageable).map(mapper::toViewRead);
        }
        BooleanExpression exp = QProduct.product.subCategory.parentCategory.id.eq(categoryId);
        return repository.findAll(exp, pageable).map(mapper::toViewRead);
    }

    public Page<ProductViewRead> getProductsBySubCategory(Long subcategoryId, Pageable pageable) {
        if (subcategoryId == null) {
            return repository.findAll(pageable).map(mapper::toViewRead);
        }
        BooleanExpression exp = QProduct.product.subCategory.id.eq(subcategoryId);
        return repository.findAll(exp, pageable).map(mapper::toViewRead);
    }
}
