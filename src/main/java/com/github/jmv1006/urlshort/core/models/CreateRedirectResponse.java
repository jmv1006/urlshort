package com.github.jmv1006.urlshort.core.models;

import com.github.jmv1006.urlshort.core.CoreDBModel;

public class CreateRedirectResponse {
    public CoreDBModel urlInfo;
    public String message;

    public CreateRedirectResponse(CoreDBModel urlInfo, String message) {
        this.urlInfo = urlInfo;
        this.message = message;
    }
}
