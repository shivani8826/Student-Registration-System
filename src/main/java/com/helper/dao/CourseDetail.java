package com.helper.dao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CourseDetails",schema = "student")
public class CourseDetail {

    @Id
    @Column(name = "Course_Id")
    private Integer courseId;

    @Column(name = "Course_Name")
    private String courseName;
    private boolean isActive;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public CourseDetail(Integer courseId, String courseName, boolean isActive) {
        this.courseId = courseId;
        this.courseName=courseName;
        this.isActive=isActive;
    }

    public CourseDetail(){

    }
}
