package com.github.jmv1006.urlshort.urlsaves.apimodels;

import com.github.jmv1006.urlshort.urlsaves.UrlSaveModel;

public class UrlSaveResponse {
    public String message;
    public UrlSaveModel urlSave;

    public UrlSaveResponse(String message, UrlSaveModel urlSave) {
        this.message = message;
        this.urlSave = urlSave;
    }
}
