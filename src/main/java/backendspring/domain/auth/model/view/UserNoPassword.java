package backendspring.domain.auth.model.view;

import backendspring.domain.auth.model.entity.Role;
import backendspring.domain.auth.model.entity.UserRoom;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserNoPassword {

    private Long id;

    private String login;

    private String password;

    private Set<Role> roles;

    private UserRoom userRoom;

}
