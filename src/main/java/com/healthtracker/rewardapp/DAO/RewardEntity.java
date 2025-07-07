package com.healthtracker.rewardapp.DAO;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reward")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RewardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rewardId;

    @Column(nullable = false)
    private String keyMonDD; // e.g., MM-YYYY/RewardUse

    @Column(nullable = false)
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Double rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}
