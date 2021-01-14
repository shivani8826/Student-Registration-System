package com.helper.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentCred implements Serializable {

    Integer id;
    String password;

    public StudentCred(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Integer getInt(StudentCred getParameter){
        return getParameter.getId();
     }

    public String getString(StudentCred getParameter){
        return getParameter.getPassword();
    }

    public StudentCred() {
    }
}

