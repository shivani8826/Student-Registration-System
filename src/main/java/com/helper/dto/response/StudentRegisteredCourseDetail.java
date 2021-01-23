package com.helper.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class StudentRegisteredCourseDetail {

    Integer courseId;
    Date dateOfRegistration;
    String courseName;


    public StudentRegisteredCourseDetail(Integer courseId, Date dateOfRegistration, String courseName) {
        this.courseId = courseId;
        this.dateOfRegistration = dateOfRegistration;
        this.courseName = courseName;
    }

    public StudentRegisteredCourseDetail()
    {

    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
