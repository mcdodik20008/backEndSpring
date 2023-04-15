package backendspring.domain.auth.service;

import backendspring.domain.auth.model.entity.User;
import backendspring.domain.auth.model.mapper.UserMapper;
import backendspring.domain.auth.model.view.UserNoPassword;
import backendspring.domain.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public static User CURRENTUSER = null;
    private final UserMapper mapper = UserMapper.INSTANCE;
    public final UserRepository repository;

    public UserNoPassword login(String login, String password){
        User user = repository.findByRoles_NameIgnoreCase(login).orElseThrow();
        CURRENTUSER = user;
        return mapper.toViewRead(user);
    }

    public Boolean logout(){
        CURRENTUSER = null;
        return true;
    }

}
