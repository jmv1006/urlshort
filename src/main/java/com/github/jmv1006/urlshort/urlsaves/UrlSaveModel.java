package com.github.jmv1006.urlshort.urlsaves;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "url-shortener:url-saves")
public class UrlSaveModel {
    @Id
    public String id;

    public String userId;

    public String urlId;

    public UrlSaveModel(String userId, String urlId) {
        this.userId = userId;
        this.urlId = urlId;
    }
}
