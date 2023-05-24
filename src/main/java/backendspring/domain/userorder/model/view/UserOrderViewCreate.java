package backendspring.domain.userorder.model.view;

import backendspring.domain.point.model.view.DeliveryPointViewRead;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserOrderViewCreate {

    private Double currentBonusPoints;

    private Double sum;

    private List<ProductOrderViewCreate> productOrder;

    private DeliveryPointViewRead deliveryPoint;

}
