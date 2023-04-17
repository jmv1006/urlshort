package com.github.jmv1006.urlshort.urlsaves.apimodels;

import com.github.jmv1006.urlshort.urlsaves.UrlSaveModel;

public class MultipleUrlSavesResponse {
    public String message;
    public UrlSaveModel[] urlSaves;

    public MultipleUrlSavesResponse(String message, UrlSaveModel[] urlSaves) {
        this.message = message;
        this.urlSaves = urlSaves;
    }
}
