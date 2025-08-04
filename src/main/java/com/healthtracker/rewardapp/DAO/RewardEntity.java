package com.healthtracker.rewardapp.DAO;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reward")

public class RewardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rewardId;

    @Column(nullable = false)
    private String keyMonDD; // e.g., MM-YYYY/RewardUse

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userParamId", nullable = false)
    private UserParamEntity userParam;

    @Column(nullable = false)
    private Double rewardPoints;

    public Long getRewardId() {
        return rewardId;
    }

    public void setRewardId(Long rewardId) {
        this.rewardId = rewardId;
    }

    public String getKeyMonDD() {
        return keyMonDD;
    }

    public void setKeyMonDD(String keyMonDD) {
        this.keyMonDD = keyMonDD;
    }

    public UserParamEntity getUserParam() {
        return userParam;
    }

    public void setUserParam(UserParamEntity userParam) {
        this.userParam = userParam;
    }

    public Double getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Double rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}
