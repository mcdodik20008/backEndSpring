package backendspring.domain.userorder.model.entity;

import backendspring.domain.user.model.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

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
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_date_time")
    private LocalDateTime orderDateTime;

    @OneToMany
    @JoinColumn(name = "user_order_id")
    private List<ProductOrder> productOrder;

    @Formula("(SELECT COUNT  FROM  WHERE _dt.id = id)")
    private Double sum;

}
