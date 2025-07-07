package com.healthtracker.rewardapp.DTO;

import com.healthtracker.rewardapp.DAO.UserParamEntity;

import java.time.LocalDate;

public class MonthlyDTO {
    private Long monthlyId;
    private Long userId;
    private Long paramId;
    private Boolean metFlag;
    private LocalDate date;

    public Long getMonthlyId() {
        return monthlyId;
    }

    public void setMonthlyId(Long monthlyId) {
        this.monthlyId = monthlyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getParamId() {
        return paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    public Boolean getMetFlag() {
        return metFlag;
    }

    public void setMetFlag(Boolean metFlag) {
        this.metFlag = metFlag;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
