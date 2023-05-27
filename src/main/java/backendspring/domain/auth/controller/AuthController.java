package backendspring.domain.auth.controller;

import backendspring.domain.auth.model.view.UserViewCreate;
import backendspring.domain.auth.model.view.UserViewRead;
import backendspring.domain.auth.model.view.UserViewUpdate;
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
    public UserViewRead login(String login, String password) {
        return service.login(login, password);
    }

    @GetMapping("/logout")
    public Boolean logout() {
        return service.logout();
    }

    @PostMapping("/registration")
    public Boolean registration(@RequestBody UserViewCreate user) {
        return service.registration(user);
    }

    @PatchMapping("/favorites/{userId}")
    public Set<Long> pathFavorites(@PathVariable Long userId, @RequestBody Set<Long> favorites) {
        return service.pathFavorites(userId, favorites);
    }

    @PutMapping("/{userId}")
    public UserViewRead update(@PathVariable Long userId, @RequestBody UserViewUpdate view) {
        return service.update(userId, view);
    }
}
