package backendspring.domain.user.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class UserRoom {

    @Setter(AccessLevel.NONE)
    @Formula("(SELECT SUM(p.price * po.count_product) FROM user_order uo JOIN product_order po ON uo.id = po.user_order_id JOIN product p ON po.product_id = p.id)")
    private Double sum;

}
