package com.github.jmv1006.urlshort.user;

import com.github.jmv1006.urlshort.security.AppSecurity;
import com.github.jmv1006.urlshort.user.apimodels.CreateUserRequest;
import com.github.jmv1006.urlshort.user.apimodels.LogInRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder encoder;
    private final UserRepository myRepo;

    public UserService(AppSecurity securityConfig, UserRepository myRepo) {
        this.encoder = securityConfig.encoder();
        this.myRepo = myRepo;
    }

    public UserModel createUser(CreateUserRequest request) {
        String username = request.username;
        String rawPassword = request.rawPassword;

        // Check if username already exists
        UserModel existingUser = myRepo.findByUsername(username);

        if(existingUser != null) {
            return null;
        }

        String encodedPassword = encoder.encode(rawPassword);
        return myRepo.save(new UserModel(username, encodedPassword));
    }

    public Optional<UserModel> findUser(String id){
        return myRepo.findById(id);
    }

    public UserModel loginUser(LogInRequest request) {
        String username = request.username;
        String password = request.password;

        UserModel user = myRepo.findByUsername(username);

        if(user == null) {
            return null;
        }
        // compare passwords

        if(!this.encoder.matches(password, user.password)) return null;

        return user;
    }

}
