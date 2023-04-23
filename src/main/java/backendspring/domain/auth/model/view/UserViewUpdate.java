package backendspring.domain.auth.model.view;

import backendspring.domain.point.model.view.DeliveryPointViewRead;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserViewUpdate {

    private String name;

    private String middleName;

    private String lastName;

    private DeliveryPointViewRead deliveryPoint;

}
