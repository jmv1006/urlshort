package com.github.jmv1006.urlshort.urlsaves;

import com.github.jmv1006.urlshort.core.CoreDBModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "url-shortener:url-saves")
public class UrlSaveModel {
    @Id
    public String id;

    public String userId;

    @DBRef
    public CoreDBModel urlInfo;

    public UrlSaveModel(String userId, CoreDBModel urlInfo) {
        this.userId = userId;
        this.urlInfo = urlInfo;
    }
}
