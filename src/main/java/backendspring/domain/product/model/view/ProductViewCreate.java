package backendspring.domain.product.model.view;

import backendspring.domain.subcategory.model.view.SubCategoryViewUpdate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductViewCreate {

    private String name;

    private Boolean controlled;

    private Double price;

    private SubCategoryViewUpdate subCategory;

    private String imageUrl;

}
