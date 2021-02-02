package com.helper.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


public class LoginResponse {


    String message;
    String success;
    String userToken;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginResponse(String message, String userToken , String success) {
        this.message = message;
        this.success = success;
        this.userToken = userToken;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public static LoginResponse buildRes(String message, String userToken, String success)
    {
        return new LoginResponse(message,userToken,success);
    }
}
