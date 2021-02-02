package com.helper.dto.request;

public class UserCred {

    Integer id;
    String password;

    public UserCred(Integer id, String password) {
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


    public Integer getInt(UserCred getParameter){
        return getParameter.getId();
     }

    public String getString(UserCred getParameter){
        return getParameter.getPassword();
    }

    public UserCred() {
    }
}

