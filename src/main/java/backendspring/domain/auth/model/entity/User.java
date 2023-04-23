package backendspring.domain.auth.model.entity;

import backendspring.domain.point.model.entity.DeliveryPoint;
import backendspring.infrasructure.view.IdsConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column(name = "favorites")
    @Convert(converter = IdsConverter.class)
    private Set<Long> favorites;

    @Embedded
    private UserRoom userRoom;

    @Column(name = "name")
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Size(min=11,max=11)
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "delivery_point_id", nullable = false, foreignKey = @ForeignKey(name = "fk_default_delivery_point"))
    private DeliveryPoint deliveryPoint;

}
