package com.helper.dao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CourseDetails",schema = "student")
public class CourseDetail {

    @Id
    private Integer Course_Id;
    private String Course_Name;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getCourse_Id() {
        return Course_Id;
    }

    public void setCourse_Id(Integer course_Id) {
        Course_Id = course_Id;
    }

    public String getCourse_Name() {
        return Course_Name;
    }

    public void setCourse_Name(String course_Name) {
        Course_Name = course_Name;
    }

    @Override
    public String toString() {
        return "CourseDetail{" +
                "Course_Id=" + Course_Id +
                ", Course_Name=" + Course_Name +
                ", isActive=" + isActive+
                '}';
    }

    public CourseDetail(Integer course_Id, String course_Name,boolean isActive) {
        Course_Id = course_Id;
        Course_Name = course_Name;
        isActive=isActive;
    }

    public CourseDetail(){

    }
}
