package com.github.jmv1006.urlshort.user.apimodels;

import jakarta.validation.constraints.Email;

public class LogInRequest {
    @Email(message = "Please enter a valid email.")
    public String username;

    public String password;

    public LogInRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
