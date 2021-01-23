package com.helper.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class StudentCourseDetail  {

    Integer courseId;
    String courseName;

    public StudentCourseDetail(Integer courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public StudentCourseDetail()
    {

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

