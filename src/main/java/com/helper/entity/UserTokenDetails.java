package com.helper.entity;

import org.springframework.data.annotation.Id;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "user_token_details")
public class UserTokenDetails {

    @javax.persistence.Id
    @Column(name="user_token")
    String userToken;

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "created_at")
    LocalDateTime  createdAt;

   @Column(name = "valid_upto")
   LocalDateTime validUpto;

    public UserTokenDetails(String userToken, Integer userId, LocalDateTime createdAt, LocalDateTime validUpto) {
        this.userToken = userToken;
        this.userId = userId;
        this.createdAt = createdAt;
        this.validUpto = validUpto;
    }

    public UserTokenDetails(){

    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getValidUpto() {
        return validUpto;
    }

    public void setValidUpto(LocalDateTime validUpto) {
        this.validUpto = validUpto;
    }
}
