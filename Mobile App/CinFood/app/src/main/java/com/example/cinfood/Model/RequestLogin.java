package com.example.cinfood.Model;

public class RequestLogin {
    private boolean status;
    private String message;
//ini berguna untuk method post


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
}
