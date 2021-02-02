package com.helper.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public class StudentRegisteredCourseDetail {

    Integer courseId;
   // Date dateOfRegistration;
    String dateOfRegistration;
    String courseName;


    public StudentRegisteredCourseDetail(Integer courseId, String dateOfRegistration, String courseName) {
        this.courseId = courseId;
        this.dateOfRegistration = dateOfRegistration;
        this.courseName = courseName;
    }

    public StudentRegisteredCourseDetail()
    {

    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }



    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
