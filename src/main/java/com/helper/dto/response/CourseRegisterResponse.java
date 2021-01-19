package com.helper.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

public class CourseRegisterResponse implements Serializable {

    String message;
    String success;
    List<String> courses;

    public CourseRegisterResponse(String message, String success, List<String>courses) {
        this.message = message;
        this.success = success;
        this.courses = courses;
    }
    public CourseRegisterResponse()
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

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
