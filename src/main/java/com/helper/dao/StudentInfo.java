package com.helper.dao;

import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.IOException;
import java.util.*;

@Entity
@Table(name="studentinfo")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StudentID;

    private String email;
    private String firstName;
    private String LastName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public StudentInfo( String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        LastName = lastName;
        this.password = password;
    }

    public StudentInfo(){
    }

}