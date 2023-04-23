package backendspring.domain.auth.service;

import backendspring.domain.auth.model.entity.User;
import backendspring.domain.auth.model.mapper.UserMapper;
import backendspring.domain.auth.model.view.UserNoPassword;
import backendspring.domain.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

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

    public Set<Long> pathFavorites(Long userId, Set<Long> favorites) {
        User user = getOne(userId);
        user.setFavorites(Set.copyOf(favorites));
        return repository.save(user).getFavorites();
    }

    public User getOne(Long userId) {
        return repository.findById(userId).orElseThrow();
    }

    public Boolean registration(User user) {
        repository.save(user);
        return true;
    }
}
