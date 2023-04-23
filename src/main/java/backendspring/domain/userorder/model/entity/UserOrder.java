package backendspring.domain.userorder.model.entity;

import backendspring.domain.auth.model.entity.User;
import backendspring.domain.point.model.entity.DeliveryPoint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "user_order")
public class UserOrder implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_date_time")
    private LocalDateTime orderDateTime;

    @Column(name = "receipt_date")
    private LocalDate receiptDate;

    @Column(name = "expected_date")
    private LocalDate expectedDate;

    @Column(name = "last_storage_day")
    private LocalDate lastStorageDay;

    @OneToMany
    @JoinColumn(name = "user_order_id")
    private List<ProductOrder> productOrder;

    @Formula("(select SUM(po.count_product * p.price) from user_order uo left join product_order po on uo.id = po.user_order_id left join product p on p.id = po.product_id where uo.id = id )")
    private Double sum;

    @ManyToOne
    @JoinColumn(name = "delivery_point_id")
    private DeliveryPoint deliveryPoint;

    /**
     * Закрыта чи не (статус)
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
