package backendspring.domain.userorder.model.view;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserOrderViewUpdate {

    private LocalDate expectedDate;

    private LocalDate lastStorageDay;

}
