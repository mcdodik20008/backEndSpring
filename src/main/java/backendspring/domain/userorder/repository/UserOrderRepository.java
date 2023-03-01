package backendspring.domain.userorder.repository;

import backendspring.domain.userorder.model.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long>, QuerydslPredicateExecutor<UserOrder> {

    UserOrder findTopByUserIdOrderByOrderDateTimeDesc(Long userId);

    UserOrder findByUserIdAndId(Long userId, Long id);

    List<UserOrder> findByUserIdOrderByOrderDateTime(Long userId);
}
