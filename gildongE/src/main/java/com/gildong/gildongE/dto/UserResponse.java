package com.gildong.gildongE.dto;

import com.gildong.gildongE.model.AuthProvider;

import java.time.LocalDateTime;

public class UserResponse {
    private String id;
    private String userName;
    private float avgDrivingScore;
//    private String loginId;
//    private AuthProvider provider;
    private LocalDateTime createdAt;

    public UserResponse() {}

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
//    public String getLoginId() {
//        return loginId;
//    }
//    public void setLoginId(String loginId) {
//        this.loginId = loginId;
//    }
//    public AuthProvider getProvider() {
//        return provider;
//    }
//    public void setProvider(AuthProvider provider) {
//        this.provider = provider;
//    }
    public float getAvgDrivingScore() {return avgDrivingScore;}
    public void setAvgDrivingScore(float avgDrivingScore) {this.avgDrivingScore = avgDrivingScore;}
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
