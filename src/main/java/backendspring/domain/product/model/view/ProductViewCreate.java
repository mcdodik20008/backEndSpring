package backendspring.domain.product.model.view;

import backendspring.domain.category.model.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductViewCreate {

    private String name;

    private Category category;

    private Boolean controlled;

    private Double price;

}
