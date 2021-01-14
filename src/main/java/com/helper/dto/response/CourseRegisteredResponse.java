package com.helper.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseRegisteredResponse implements Serializable {

    String message;
    String success;
    List<String> courses;

    public CourseRegisteredResponse(String message, String success,List<String>courses) {
        this.message = message;
        this.success = success;
        this.courses = courses;
    }
    public CourseRegisteredResponse()
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
