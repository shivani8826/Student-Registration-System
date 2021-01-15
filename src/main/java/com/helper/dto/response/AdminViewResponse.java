package com.helper.dto.response;

import com.helper.dto.request.AdminCred;

import java.util.List;

public class AdminViewResponse {

    String message;
    List<AdminView> allStudentDetails;



    public AdminViewResponse()
    {

    }

    public AdminViewResponse(String message, List<AdminView> allStudentDetails) {
        this.message = message;
        this.allStudentDetails = allStudentDetails;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AdminView> getAllStudentDetails() {
        return allStudentDetails;
    }

    public void setAllStudentDetails(List<AdminView> allStudentDetails) {
        this.allStudentDetails = allStudentDetails;
    }
}
