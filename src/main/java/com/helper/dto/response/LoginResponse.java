package com.helper.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse implements Serializable {

    String success;
    String message;

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

    public LoginResponse(String success, String message) {
        this.success = success;
        this.message = message;
    }

    public static LoginResponse buildRes(String success, String message)
    {
        return new LoginResponse(success,message);
    }
}
