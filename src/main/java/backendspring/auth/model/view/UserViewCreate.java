package backendspring.auth.model.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserViewCreate {

    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private Integer age;
}
