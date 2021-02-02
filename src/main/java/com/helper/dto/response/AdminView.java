package com.helper.dto.response;


import java.util.ArrayList;
import java.util.List;

public class AdminView {

    Integer studentId;
    String courseName;
  //  List<StudentCourseDetail> courseNameIdList=new ArrayList<>();
    Integer courseId;

    public AdminView(Integer studentId,  Integer courseId, String courseName) {
        this.studentId = studentId;
        this.courseName = courseName;
        this.courseId = courseId;
    }

    public AdminView()
    {

    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getCourse_Name() {
        return courseName;
    }

    public void setCourse_Name(String course_Name) {
        this.courseName = course_Name;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
