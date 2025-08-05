package com.healthtracker.rewardapp.DTO;

import com.healthtracker.rewardapp.DAO.UserParamEntity;

import java.time.LocalDate;

public class DailyDTO {
    private Long dailyId;
    private Long userId;
    private Long paramId;
   private Boolean metFlag;
    private LocalDate date;
    private Boolean skipFlag;

    public Long getDailyId() {
        return dailyId;
    }

    public void setDailyId(Long dailyId) {
        this.dailyId = dailyId;
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

    public Boolean getSkipFlag() {
        return skipFlag;
    }

    public void setSkipFlag(Boolean skipFlag) {
        this.skipFlag = skipFlag;
    }
}