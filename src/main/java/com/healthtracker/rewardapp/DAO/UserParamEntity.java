package com.healthtracker.rewardapp.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_param")

public class UserParamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userParamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "param_id", nullable = false)
    private ParameterEntity parameter;

    @Column(nullable = false)
    private String status;  // active/inactive

    @OneToMany(mappedBy = "userParam", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<DailyEntity> daily = new ArrayList<>();

    @OneToMany(mappedBy = "userParam", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<MonthlyEntity> monthly = new ArrayList<>();

    @OneToMany(mappedBy = "userParam", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<RewardEntity> reward = new ArrayList<>();

    public UserParamEntity() {
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ParameterEntity getParameter() {
        return parameter;
    }

    public void setParameter(ParameterEntity parameter) {
        this.parameter = parameter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserParamId() {
        return userParamId;
    }

    public void setUserParamId(Long userParamId) {
        this.userParamId = userParamId;
    }

    public List<DailyEntity> getDaily() {
        return daily;
    }

    public void setDaily(List<DailyEntity> daily) {
        this.daily = daily;
    }

    public List<MonthlyEntity> getMonthly() {
        return monthly;
    }

    public void setMonthly(List<MonthlyEntity> monthly) {
        this.monthly = monthly;
    }

    public List<RewardEntity> getReward() {
        return reward;
    }

    public void setReward(List<RewardEntity> reward) {
        this.reward = reward;
    }
}
