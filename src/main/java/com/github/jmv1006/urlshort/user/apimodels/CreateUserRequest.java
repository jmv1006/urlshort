package com.github.jmv1006.urlshort.user.apimodels;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
    @Size(min = 1, message = "Username must be of at least length 1.")
    @Email()
    public String username;
    @Size(min = 8, message = "Password must be of at least length 8.")
    public String rawPassword;

    @Size(min = 8, message = "Password must be of at least length 8.")
    public String confirmedPassword;

    @AssertTrue(message = "Passwords must match.")
    public boolean isAssertTrue() {
        return this.rawPassword.equals(this.confirmedPassword);
    }

    public CreateUserRequest(String username, String rawPassword, String confirmedPassword) {
        this.username = username;
        this.rawPassword = rawPassword;
        this.confirmedPassword = confirmedPassword;
    }
}
