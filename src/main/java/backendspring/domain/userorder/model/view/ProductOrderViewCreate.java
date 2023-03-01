package backendspring.domain.userorder.model.view;

import backendspring.infrasructure.view.ReferenceView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderViewCreate {

    private ReferenceView product;

    private Long countProduct;

}
