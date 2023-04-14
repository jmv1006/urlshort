package com.github.jmv1006.urlshort.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "url-shortener:users")
public class UserModel {
    @Id
    public String id;

    public String username;

    public String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
