package com.helper.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.helper.entity.CourseDetail;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseViewResponse implements Serializable {

    String message;
    boolean success;
    List<CourseNameId> data;


    public CourseViewResponse(String message, boolean success, List<CourseNameId> data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public CourseViewResponse(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<CourseNameId> getData() {
        return data;
    }

    public void setData(List<CourseNameId> data) {
        this.data = data;
    }
}
