package backendspring.domain.auth.model.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoomViewCreate {

    // Не используется?
    //@Formula("(SELECT SUM(p.price * po.count_product) FROM user_order uo JOIN product_order po ON uo.id = po.user_order_id JOIN product p ON po.product_id = p.id)")
    //@Formula("(SELECT SUM(uo.user_order_sum) FROM user_order uo JOIN users ON uo.user_id = users.id)")
    private Double sum;

    private Integer bonusPoints;

}
