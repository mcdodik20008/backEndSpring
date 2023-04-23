package backendspring.domain.auth.model.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserViewCreate {

    private String login;

    private String password;

    private String name;

    private String middleName;

    private String lastName;

    private String phoneNumber;

}
