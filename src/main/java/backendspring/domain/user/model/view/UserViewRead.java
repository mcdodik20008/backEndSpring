package backendspring.domain.user.model.view;

import backendspring.domain.user.model.entity.UserRoom;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserViewRead {

    private Long id;

    @Length(min = 5, message = "*Your user name must have at least 5 characters")
    @NotEmpty(message = "*Please provide a user name")
    private String userName;

    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @NotEmpty(message = "*Please provide your name")
    private String name;

    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    private UserRoom userRoom;

}
