package com.helper.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.helper.entity.StudentInfo;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class   OnboardResponse implements Serializable {

    private Integer id;
    private String message;
    private String success;

    public OnboardResponse(Integer id, String message, String success) {
        this.id = id;
        this.message = message;
        this.success = success;
    }

    public OnboardResponse(){

    }

    public static OnboardResponse buildResp(int studentId, String message, String success) {
        return new OnboardResponse(studentId,message,success);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
