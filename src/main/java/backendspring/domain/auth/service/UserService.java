package backendspring.domain.auth.service;

import backendspring.domain.auth.model.entity.User;
import backendspring.domain.auth.model.mapper.UserMapper;
import backendspring.domain.auth.model.view.UserViewCreate;
import backendspring.domain.auth.model.view.UserViewRead;
import backendspring.domain.auth.model.view.UserViewUpdate;
import backendspring.domain.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {

    public static User CURRENTUSER = null;
    private final UserMapper mapper = UserMapper.INSTANCE;
    private final UserRepository repository;

    public UserViewRead login(String login, String password){
        User user = repository.findByLogin(login).orElseThrow();
        if (!user.getPassword().equals(password))
            throw new RuntimeException("Не верный логин или пароль");
        CURRENTUSER = user;
        return mapper.toViewRead(user);
    }

    public Boolean logout(){
        CURRENTUSER = null;
        return true;
    }

    public UserViewRead update(Long id, UserViewUpdate view) {
        var entity = getObject(id);
        mapper.fromViewUpdate(entity, view);
        repository.save(entity);
        return mapper.toViewRead(entity);
    }

    public Set<Long> pathFavorites(Long userId, Set<Long> favorites) {
        User user = getObject(userId);
        user.setFavorites(Set.copyOf(favorites));
        return repository.save(user).getFavorites();
    }

    public UserViewRead getOne(Long userId) {
        return mapper.toViewRead(getObject(userId));
    }

    public Boolean registration(UserViewCreate view)  {
        var entity = mapper.fromViewUpdate(view);
        repository.save(entity);
        return true;
    }

    public User getObject(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Не найден пользователь с идентификатором " + id));
    }
}
