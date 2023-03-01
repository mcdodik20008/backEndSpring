package backendspring.domain.userorder.model.view;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserOrderViewCreate {

    private List<ProductOrderViewCreate> productOrder;

}
