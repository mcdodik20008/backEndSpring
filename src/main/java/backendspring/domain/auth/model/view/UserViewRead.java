package backendspring.domain.auth.model.view;

import backendspring.domain.auth.model.entity.Role;
import backendspring.domain.auth.model.entity.UserRoom;
import backendspring.domain.point.model.view.DeliveryPointViewRead;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserViewRead {

    private Long id;

    private String login;

    private String password;

    private Set<Role> roles;

    private Set<Long> favorites;

    private UserRoom userRoom;

    private String name;

    private String middleName;

    private String lastName;

    private String phoneNumber;

    private DeliveryPointViewRead deliveryPoint;

}
