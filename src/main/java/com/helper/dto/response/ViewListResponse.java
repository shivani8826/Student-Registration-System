package com.helper.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewListResponse  {

    String success;
    String message;
    List<StudentRegisteredCourseDetail> studentRegisteredCourseDetail;


    public ViewListResponse() {

    }


    public ViewListResponse(String success, String message, List<StudentRegisteredCourseDetail> studentRegisteredCourseDetail) {
        this.success = success;
        this.message = message;
        this.studentRegisteredCourseDetail = studentRegisteredCourseDetail;
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

    public List<StudentRegisteredCourseDetail> getCourseList() {
        return studentRegisteredCourseDetail;
    }

    public void setCourseList(List<StudentRegisteredCourseDetail> studentRegisteredCourseDetail) {
        this.studentRegisteredCourseDetail = studentRegisteredCourseDetail;
    }
}

