package com.example.myapplication.Model;

import java.util.List;

public class LoginResponse {

    private boolean status;
    private String message;
    private List<Login> user_login;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Login> getUser_login() {
        return user_login;
    }

    public void setUser_login(List<Login> user_login) {
        this.user_login = user_login;
    }
}
