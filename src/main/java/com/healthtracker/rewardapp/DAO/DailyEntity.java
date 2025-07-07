package com.healthtracker.rewardapp.DAO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "daily")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DailyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dailyId;

    @Column(nullable = false)
    private Long userParamId;

    @Column(nullable = false)
    private Integer rewardVal;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Boolean isMetFlag;

    @Column(nullable = false)
    private Long userId;

    public Long getDailyId() {
        return dailyId;
    }

    public void setDailyId(Long dailyId) {
        this.dailyId = dailyId;
    }

    public Long getUserParamId() {
        return userParamId;
    }

    public void setUserParamId(Long userParamId) {
        this.userParamId = userParamId;
    }

    public Integer getRewardVal() {
        return rewardVal;
    }

    public void setRewardVal(Integer rewardVal) {
        this.rewardVal = rewardVal;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getMetFlag() {
        return isMetFlag;
    }

    public void setMetFlag(Boolean metFlag) {
        isMetFlag = metFlag;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
