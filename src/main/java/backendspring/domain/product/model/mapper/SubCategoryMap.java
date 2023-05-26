package backendspring.domain.product.model.mapper;

import backendspring.domain.subcategory.model.entity.SubCategory;
import backendspring.infrasructure.view.ReferenceView;

public interface SubCategoryMap {

    default SubCategory toSubCategory(ReferenceView view) {
        SubCategory entity = new SubCategory();
        entity.setId(view.getId());
        return entity;
    }

}
