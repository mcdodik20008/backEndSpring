package backendspring.domain.product.model.view;

import backendspring.domain.subcategory.model.entity.SubCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductViewRead {

    private Long id;

    private String name;

    private SubCategory subCategory;

    private Boolean controlled;

    private String imageUrl;

    private Double price;

}
