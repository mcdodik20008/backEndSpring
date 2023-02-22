package backendspring.auth.service;

import backendspring.auth.model.entity.User;
import backendspring.auth.model.mapper.UserMapper;
import backendspring.auth.model.view.UserViewCreate;
import backendspring.auth.model.view.UserViewRead;
import backendspring.auth.repository.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Objects;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService implements UserDetailsService {

    UserRepository repository;

    UserMapper mapper = UserMapper.INSTANCE;

    public Page<UserViewRead> getCategories(BooleanExpression expression, Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toViewRead);
    }

    public UserViewRead getOne(Long id) {
        return mapper.toViewRead(getObject(id));
    }

    public Long create(UserViewCreate view) {
        var entity = mapper.fromViewCreate(view);
        return repository.save(entity).getId();
    }

    public void update(Long id, UserViewCreate view) {
        var entity = getObject(id);
        mapper.fromViewCreate(entity, view);
        repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private User getObject(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Не найден пользователь с идентификатором " + id));
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = getByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(), true, true, true, true, new HashSet<>());
    }

    public User getByLogin(String login) {
        return this.repository.getByLogin(login);
    }
}
