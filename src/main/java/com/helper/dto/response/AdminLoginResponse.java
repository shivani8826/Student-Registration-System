package com.helper.dto.response;

public class AdminLoginResponse {

    String message;
    String success;

    public AdminLoginResponse(String message, String success) {
        this.message = message;
        this.success = success;
    }

    public AdminLoginResponse()
    {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
