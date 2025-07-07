package com.healthtracker.rewardapp.DTO;

import com.healthtracker.rewardapp.DAO.UserEntity;

public class RewardRequestDTO {
    private String key;
    private Long userId;

    private Double rewardAdjustment;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getRewardAdjustment() {
        return rewardAdjustment;
    }

    public void setRewardAdjustment(Double rewardAdjustment) {
        this.rewardAdjustment = rewardAdjustment;
    }
}
