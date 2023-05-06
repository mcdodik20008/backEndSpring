package backendspring.domain.product.model.view;

import backendspring.infrasructure.view.ReferenceView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductViewUpdate {

    private String name;

    private Boolean controlled;

    private Double price;

    private ReferenceView subCategoryId;

    private String imageUrl;

}
