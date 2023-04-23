package backendspring.domain.point.model.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryPointViewCreate {

    private String name;

    private String address;

    private String workStart;

    private String workEnd;

}
