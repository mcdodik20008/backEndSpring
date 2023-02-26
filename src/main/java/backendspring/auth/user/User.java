package backendspring.auth.user;

import backendspring.auth.roles.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity(name = "auth_user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", updatable = false)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @OneToMany(fetch = LAZY, mappedBy = "user", cascade = PERSIST)
    private List<UserRole> communityRoles = new ArrayList<>();

    @Embedded
    private UserSpace userSpace;

}
