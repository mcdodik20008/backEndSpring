package backendspring.domain.subcategory.repository;

import backendspring.domain.subcategory.model.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long>, QuerydslPredicateExecutor<SubCategory> {

}
