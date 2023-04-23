package backendspring.domain.point.model.view;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class DeliveryPointViewCreate {

    private String name;

    private String address;

    private String workStart;

    private String workEnd;

}
