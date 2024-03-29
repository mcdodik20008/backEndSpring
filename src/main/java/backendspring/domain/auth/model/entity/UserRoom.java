package backendspring.domain.auth.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class UserRoom {

    // Не используется?
    @Setter(AccessLevel.NONE)
    //@Formula("(SELECT SUM(p.price * po.count_product) FROM user_order uo JOIN product_order po ON uo.id = po.user_order_id JOIN product p ON po.product_id = p.id)")
    //@Formula("(SELECT SUM(uo.user_order_sum) FROM user_order uo JOIN users ON uo.user_id = users.id)")
    private Double sum;

    @Column(name = "bonus_points")
    private Integer bonusPoints;

}