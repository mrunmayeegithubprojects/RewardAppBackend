package com.healthtracker.rewardapp.DTO;

import java.util.List;

public class UserParameterRequestDTO {
    private Long userId;
    private List<Long> parameterIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getParameterIds() {
        return parameterIds;
    }

    public void setParameterIds(List<Long> parameterIds) {
        this.parameterIds = parameterIds;
    }
}
