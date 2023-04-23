package backendspring.domain.auth.controller;

import backendspring.domain.auth.model.entity.User;
import backendspring.domain.auth.model.view.UserNoPassword;
import backendspring.domain.auth.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = "/auth", produces = "application/json")
public class AuthController {

    private final UserService service;

    @GetMapping("/login")
    public UserNoPassword login(String login, String password) {
        return service.login(login, password);
    }

    @GetMapping("/logout")
    public Boolean logout() {
        return service.logout();
    }

    @PostMapping("/registration")
    public Boolean registration(User user) {
        return service.registration(user);
    }

    @PatchMapping("/favorites/{userId}")
    public Set<Long> pathFavorites(@PathVariable Long userId, @RequestBody  Set<Long> favorites) {
        return service.pathFavorites(userId, favorites);
    }

    @PutMapping("/{id}")
    public UserNoPassword update(@PathVariable Long id, @RequestBody UserNoPassword view) {
        service.update(id, view);
        return service.getOneAsView(id);
    }
}
