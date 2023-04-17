package com.github.jmv1006.urlshort.user.apimodels;


public class UserBaseResponse {
    public String message;
    public UserResponseModel user;

    public UserBaseResponse(UserResponseModel user, String message) {
        this.user = user;
        this.message = message;
    }
}
