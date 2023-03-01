package backendspring.domain.userorder.model.view;

import backendspring.domain.product.model.view.ProductViewRead;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderViewRead {

    private Long id;

    private ProductViewRead product;

    private Long countProduct;

}
