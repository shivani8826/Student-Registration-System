package com.helper.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "StudentCourseInfo" ,schema="student")
public class StudentCourseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    @Column(name = "Student_Id")
    Integer studentId;

    @Column(name = "Course_Id")
    Integer courseId;

    @JsonFormat(pattern = "mm-dd-yyyy")
    @Column(name = "Date_of_Registration")
    private Date dateOfRegistration;

    @Column(name = "Validity_in_Days")
    Integer validityInDays;

    public StudentCourseInfo(Integer studentId, Integer courseId, Date dateOfRegistration, Integer validityInDays) {
      this.studentId=studentId;
      this.courseId=courseId;
      this.dateOfRegistration=dateOfRegistration;
      this.validityInDays=validityInDays;
    }

    public StudentCourseInfo(){

    }


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public Integer getValidityInDays() {
        return validityInDays;
    }

    public void setValidityInDays(Integer validityInDays) {
        this.validityInDays = validityInDays;
    }
}
