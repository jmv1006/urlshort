package com.github.jmv1006.urlshort.urlsaves;

import com.github.jmv1006.urlshort.api.models.DBModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "url-shortener:url-saves")
public class UrlSaveModel {
    @Id
    public String id;

    public String userId;

    @DBRef
    public DBModel urlInfo;

    public UrlSaveModel(String userId, DBModel urlInfo) {
        this.userId = userId;
        this.urlInfo = urlInfo;
    }
}
