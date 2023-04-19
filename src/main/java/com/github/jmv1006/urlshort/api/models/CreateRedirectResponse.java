package com.github.jmv1006.urlshort.api.models;

public class CreateRedirectResponse {
    public DBModel urlInfo;
    public String message;

    public CreateRedirectResponse(DBModel urlInfo, String message) {
        this.urlInfo = urlInfo;
        this.message = message;
    }
}
