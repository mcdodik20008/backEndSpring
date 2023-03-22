package backendspring.domain.point.repository;

import backendspring.domain.point.model.entity.DeliveryPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DeliveryPointRepository extends JpaRepository<DeliveryPoint, Long>, QuerydslPredicateExecutor<DeliveryPoint> {

}
