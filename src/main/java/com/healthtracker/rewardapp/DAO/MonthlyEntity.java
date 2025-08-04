package com.healthtracker.rewardapp.DAO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "monthly")

public class MonthlyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monthlyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userParamId", nullable = false)
    private UserParamEntity userParam;

    @Column(nullable = false)
    private Integer rewardVal;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Boolean isMetFlag;

    public MonthlyEntity() {
    }

    public Long getMonthlyId() {
        return monthlyId;
    }

    public void setMonthlyId(Long monthlyId) {
        this.monthlyId = monthlyId;
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

    public UserParamEntity getUserParam() {
        return userParam;
    }

    public void setUserParam(UserParamEntity userParam) {
        this.userParam = userParam;
    }
}
