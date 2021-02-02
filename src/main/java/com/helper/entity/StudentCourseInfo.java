package com.helper.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "student_course_info", schema = "student")
public class StudentCourseInfo {

    @javax.persistence.Id       //else Bean Creation error came
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "student_id")
    Integer studentId;

    @Column(name = "course_id")
    Integer courseId;

    @Column(name = "date_of_registration")
    private Date dateOfRegistration;

    @Column(name = "validity_in_days")
    Integer validityInDays;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    public StudentCourseInfo(Integer studentId, Integer courseId, Date dateOfRegistration, Integer validityInDays, LocalDateTime createdAt) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.dateOfRegistration = dateOfRegistration;
        this.validityInDays = validityInDays;
        this.createdAt = createdAt;
    }

    public StudentCourseInfo() {

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
