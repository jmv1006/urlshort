package com.github.jmv1006.urlshort.user;

import com.github.jmv1006.urlshort.user.apimodels.CreateUserRequest;
import com.github.jmv1006.urlshort.user.apimodels.LogInRequest;
import com.github.jmv1006.urlshort.user.apimodels.UserBaseResponse;
import com.github.jmv1006.urlshort.user.apimodels.UserResponseModel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {
    private final UserService myService;

    public UserController(UserService myService) {
        this.myService = myService;
    }

    @PostMapping("/user/log-in")
    public ResponseEntity logInUser(@Valid @RequestBody LogInRequest request) {
        UserModel user = myService.loginUser(request);

        if(user == null) {
            UserBaseResponse res = new UserBaseResponse(null, "Could not log in with given credentials.");
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        UserResponseModel resUser = new UserResponseModel(user.id, user.username);
        UserBaseResponse res = new UserBaseResponse(resUser, "Success");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUser(@PathVariable String id) {
        Optional<UserModel> userOpt = myService.findUser(id);

        if(userOpt.isEmpty()) {
            UserBaseResponse res = new UserBaseResponse(null, "Could not find user with given credentials.");
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        UserResponseModel resUser = new UserResponseModel(userOpt.get().id, userOpt.get().username);

        UserBaseResponse res = new UserBaseResponse(resUser, "Success");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@Valid @RequestBody CreateUserRequest request) {
        UserModel createdUser = myService.createUser(request);

        if(createdUser == null) {
            UserBaseResponse res = new UserBaseResponse(null, "Error Creating User.");
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        UserResponseModel resUser = new UserResponseModel(createdUser.id, createdUser.username);
        UserBaseResponse res = new UserBaseResponse(resUser, "Successfully Created User");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
