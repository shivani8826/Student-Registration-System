package com.helper.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.helper.entity.CourseDetail;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseViewResponse implements Serializable {

    String message;
    boolean success;
    List<CourseDetail> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CourseDetail> getData() {
        return data;
    }

    public void setL(List<CourseDetail> data) {
        this.data = data;
    }

    public CourseViewResponse(boolean success,String message, List<CourseDetail> data) {
        this.message = message;
        this.success=success;
        this.data = data;
    }
}
