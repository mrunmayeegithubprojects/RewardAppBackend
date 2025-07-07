package com.healthtracker.rewardapp.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long userId;
    private String name;
    private String emailId;
    private String phoneNo;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String status;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
