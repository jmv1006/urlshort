package com.github.jmv1006.urlshort.api;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "url-shortener")
public class DBModel {
    @Id
    public String id;
    public String url;
    public String redirect;

    public DBModel(String url, String redirect) {
        this.url = url;
        this.redirect = redirect;
    }
}
