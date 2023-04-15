package backendspring.domain.auth.controller;

import backendspring.domain.auth.model.view.UserNoPassword;
import backendspring.domain.auth.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
