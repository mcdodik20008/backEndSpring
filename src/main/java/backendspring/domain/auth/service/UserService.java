package backendspring.domain.auth.service;

import backendspring.domain.auth.model.entity.User;
import backendspring.domain.auth.model.mapper.UserMapper;
import backendspring.domain.auth.model.view.UserNoPassword;
import backendspring.domain.auth.repository.UserRepository;
import backendspring.domain.category.model.entity.Category;
import backendspring.domain.subcategory.model.view.SubCategoryViewCreate;
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

    public UserNoPassword login(String login, String password){
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

    public void update(Long id, UserNoPassword view) {
        var entity = getObject(id);
        mapper.fromViewCreate(entity, view);
        repository.save(entity);
    }

    public Set<Long> pathFavorites(Long userId, Set<Long> favorites) {
        User user = getOneAsObject(userId);
        user.setFavorites(Set.copyOf(favorites));
        return repository.save(user).getFavorites();
    }

    public User getOneAsObject(Long userId) {
        return repository.findById(userId).orElseThrow();
    }

    public UserNoPassword getOneAsView(Long userId) {
        return mapper.toViewRead(getObject(userId));
    }

    public Boolean registration(User user) {
        repository.save(user);
        return true;
    }

    private User getObject(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        "Не найден пользователь с идентификатором " + id));
    }
}
