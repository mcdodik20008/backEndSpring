package backendspring.domain.userorder.model.entity;

import backendspring.domain.auth.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "user_order")
public class UserOrder{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private User user;

    private LocalDateTime orderDateTime;

    @OneToMany
    @JoinColumn(name = "user_order_id")
    private List<ProductOrder> productOrder;

}
