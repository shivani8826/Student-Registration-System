package com.helper.dto.response;

import java.io.Serializable;
import java.util.List;


public class CourseViewResponse {

    String message;
    boolean success;
    List<StudentCourseDetail> data;


    public CourseViewResponse(String message, boolean success, List<StudentCourseDetail> data) {
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

    public List<StudentCourseDetail> getData() {
        return data;
    }

    public void setData(List<StudentCourseDetail> data) {
        this.data = data;
    }
}
