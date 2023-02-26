package backendspring.auth.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Long>,QuerydslPredicateExecutor<User> {

    User findByLogin(String name);
}
