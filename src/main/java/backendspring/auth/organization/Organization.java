package backendspring.auth.organization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

}
