package backendspring.domain.product.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductSearchFilter {

    String name;
    Double minPrice;
    Double maxPrice;
    Boolean controlled;
    Long categoryId;
    Long subCategoryId;
    Boolean isAvailable;

    @JsonIgnore
    public BooleanExpression getPredicate() {
        QProduct qProduct = QProduct.product;
        BooleanExpression exp = qProduct.id.isNotNull();
        if (this.name != null)
            exp = qProduct.name.startsWith(this.name);
        if (this.controlled != null)
            exp = exp.and(qProduct.controlled.eq(this.controlled));
        if (this.minPrice != null)
            exp = exp.and(qProduct.price.goe(this.minPrice));
        if (this.maxPrice != null)
            exp = exp.and(qProduct.price.loe(this.maxPrice));
        if (this.categoryId != null && this.subCategoryId == null)
            exp = exp.and(qProduct.subCategory.parentCategory.id.eq(categoryId));
        if (this.subCategoryId != null && this.categoryId == null)
            exp = exp.and(qProduct.subCategory.id.eq(subCategoryId));
        if (this.isAvailable != null)
            exp = exp.and(qProduct.isAvailable.eq(isAvailable));
        return exp;
    }

}
