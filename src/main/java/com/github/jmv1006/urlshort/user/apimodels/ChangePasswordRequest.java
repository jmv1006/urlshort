package com.github.jmv1006.urlshort.user.apimodels;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ChangePasswordRequest {

    @NotBlank
    public String id;

    @NotBlank
    public String oldPassword;

    @Size(min = 8, message = "Password must be of at least length 8.")
    @NotBlank
    public String newPassword;

    @Size(min = 8, message = "Password must be of at least length 8.")
    @NotBlank
    public String confirmedNewPassword;

    @AssertTrue
    public boolean isAssertTrue() {
        if (this.newPassword == null || this.confirmedNewPassword == null) return false;
        return this.newPassword.equals(this.confirmedNewPassword);
    }

    public ChangePasswordRequest(String id, String oldPassword, String newPassword, String confirmedNewPassword) {
        this.id = id;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmedNewPassword = confirmedNewPassword;
    }
}
