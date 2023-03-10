package backendspring.domain.product.model.view;

import backendspring.domain.category.model.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductViewRead {

    private Long id;

    private String name;

    private Double price;

    private Boolean controlled;

    private Category category;

}
