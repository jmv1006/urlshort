package com.github.jmv1006.urlshort.api.models;

public class ResponseModel {
    public String url;
    public String message;

    public ResponseModel(String base, String url, String message) {
        this.url = base + url;
        this.message = message;
    }
}