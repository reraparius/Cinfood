package com.example.cinfood.Model;

import com.google.gson.annotations.SerializedName;

public class loginResponse {
    @SerializedName("data")
    private LoginData loginData;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public LoginData getLoginData() {
        return loginData;
    }

    public void setLoginData(LoginData loginData) {
        this.loginData = loginData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
