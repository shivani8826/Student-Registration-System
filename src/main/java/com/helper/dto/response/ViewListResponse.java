package com.helper.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewListResponse implements Serializable {

    String success;
    String message;
    List<CourseList> courseList;


    public ViewListResponse() {

    }


    public ViewListResponse(String success, String message, List<CourseList> courseList) {
        this.success = success;
        this.message = message;
        this.courseList = courseList;
    }


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

    public List<CourseList> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseList> courseList) {
        this.courseList = courseList;
    }
}

