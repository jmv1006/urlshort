package com.github.jmv1006.urlshort.api.models;

public class CreateRedirectResponse {
    public String url;
    public String message;

    public CreateRedirectResponse(String base, String url, String message) {
        this.url = base + url;
        this.message = message;
    }
}
