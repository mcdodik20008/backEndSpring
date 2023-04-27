package backendspring.domain.product.model.view;

import backendspring.domain.subcategory.model.view.SubCategoryViewRead;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductViewCreate {

    private String name;

    private Boolean controlled;

    private Double price;

    private SubCategoryViewRead subCategory;

}
