package com.healthtracker.rewardapp.DAO;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "daily")

public class DailyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dailyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userParamId", nullable = false)
    private UserParamEntity userParam;

    @Column(nullable = false)
    private Integer rewardVal;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Boolean isMetFlag;

    public DailyEntity() {
    }

    public Long getDailyId() {
        return dailyId;
    }

    public void setDailyId(Long dailyId) {
        this.dailyId = dailyId;
    }

    public UserParamEntity getUserParam() {
        return userParam;
    }

    public void setUserParam(UserParamEntity userParam) {
        this.userParam = userParam;
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
}
