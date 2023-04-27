package backendspring.domain.userorder.model.view;

import backendspring.domain.userorder.model.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserOrderViewRead {

    private Long id;

    private LocalDateTime orderDateTime;

    private List<ProductOrderViewRead> productOrder;

    private Double sum;

    private OrderStatus status;

}
