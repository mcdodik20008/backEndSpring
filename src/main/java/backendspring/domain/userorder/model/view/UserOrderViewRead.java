package backendspring.domain.userorder.model.view;

import backendspring.domain.auth.model.view.UserViewShort;
import backendspring.domain.point.model.view.DeliveryPointViewRead;
import backendspring.domain.userorder.model.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserOrderViewRead {

    private UserViewShort user;

    private Long id;

    private LocalDateTime orderDateTime;

    private LocalDate expectedDate;

    private LocalDate lastStorageDay;

    private List<ProductOrderViewRead> productOrder;

    private Double sum;

    private DeliveryPointViewRead deliveryPoint;

    private OrderStatus status;

}
