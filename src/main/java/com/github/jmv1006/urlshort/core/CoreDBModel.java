package com.github.jmv1006.urlshort.core;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "url-shortener")
public class CoreDBModel {
    @Id
    public String id;
    public String url;
    public String redirect;

    public CoreDBModel(String url, String redirect) {
        this.url = url;
        this.redirect = redirect;
    }
}
