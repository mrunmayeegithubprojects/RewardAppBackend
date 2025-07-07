package com.healthtracker.rewardapp.DTO;

import com.healthtracker.rewardapp.DAO.UserEntity;

public class RewardResponseDTO {
    private Long rewardId;
    private String key;
    private Long userId;
    private Integer rewardPoints;

    public Long getRewardId() {
        return rewardId;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public void setRewardId(Long rewardId) {
        this.rewardId = rewardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}
