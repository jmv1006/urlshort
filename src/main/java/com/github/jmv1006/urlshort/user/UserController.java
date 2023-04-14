package com.github.jmv1006.urlshort.user;

import com.github.jmv1006.urlshort.user.apimodels.CreateUserRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {
    private final UserService myService;

    public UserController(UserService myService) {
        this.myService = myService;
    }

    @GetMapping("/user")
    public String getUser() {
        return "User Route";
    }

    @PostMapping("/user")
    public UserModel createUser(@Valid @RequestBody CreateUserRequest request) {
        return myService.createUser(request);
    }
}
