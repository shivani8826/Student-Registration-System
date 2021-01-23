package com.helper.dto.response;


import java.util.ArrayList;
import java.util.List;

public class AdminView {

    Integer studentId;
    String course_Name;
  //  List<StudentCourseDetail> courseNameIdList=new ArrayList<>();
    Integer courseId;

    public AdminView(Integer studentId,  Integer courseId, String course_Name) {
        this.studentId = studentId;
        this.course_Name = course_Name;
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
        return course_Name;
    }

    public void setCourse_Name(String course_Name) {
        this.course_Name = course_Name;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
