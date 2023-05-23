package backendspring.domain.product.model.view;

import backendspring.domain.subcategory.model.view.SubCategoryViewRead;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductViewRead {

    private Long id;

    private String name;

    private SubCategoryViewRead subCategory;

    private Boolean controlled;

    private String imageUrl;

    private Double price;

    private String description;

    private Boolean isAvailable;

}
