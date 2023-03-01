package backendspring.domain.userorder.repository;

import backendspring.domain.userorder.model.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long>, QuerydslPredicateExecutor<ProductOrder> {

}
