package backendspring.domain.product.model.view;

import backendspring.infrasructure.view.ReferenceView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductViewCreate {

    private String name;

    private Boolean controlled;

    private Double price;

    private ReferenceView subCategory;

    private String imageUrl;

}
