package backendspring.domain.product.model.view;

import backendspring.domain.category.model.view.CategoryViewRead;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductViewCreate {

    private String name;

    private CategoryViewRead category;

    private Double price;

    private Boolean controlled;

}
