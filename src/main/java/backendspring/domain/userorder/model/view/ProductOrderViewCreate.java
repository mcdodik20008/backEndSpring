package backendspring.domain.userorder.model.view;

import backendspring.domain.product.model.view.ProductViewRead;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderViewCreate {

    private ProductViewRead product;

    private Long countProduct;

}
