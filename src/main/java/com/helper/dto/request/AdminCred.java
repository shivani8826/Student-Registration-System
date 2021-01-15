package com.helper.dto.request;


public class AdminCred {

    Integer adminId;
    String password;
    boolean userType;

    public AdminCred(Integer adminId, String password, boolean userType) {
        this.adminId = adminId;
        this.password = password;
        this.userType = userType;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }
}
