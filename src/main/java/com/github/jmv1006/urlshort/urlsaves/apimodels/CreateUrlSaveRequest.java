package com.github.jmv1006.urlshort.urlsaves.apimodels;

import jakarta.validation.constraints.NotNull;

public class CreateUrlSaveRequest {
    @NotNull
    public String userId;

    @NotNull
    public String urlId;

    public CreateUrlSaveRequest(String userId, String urlId) {
        this.urlId = urlId;
        this.userId = userId;
    }
}
