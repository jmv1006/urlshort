package com.github.jmv1006.urlshort.user;

import com.github.jmv1006.urlshort.security.AppSecurity;
import com.github.jmv1006.urlshort.user.apimodels.CreateUserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

        String encodedPassword = encoder.encode(rawPassword);

        return myRepo.save(new UserModel(username, encodedPassword));
    }

}
