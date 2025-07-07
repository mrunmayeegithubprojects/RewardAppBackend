package com.healthtracker.rewardapp.DAO;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_param")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserParamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userParamId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "param_id", nullable = false)
    private Long parameterId;

    @Column(nullable = false)
    private String status;  // active/inactive

    public Long getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public Long getUserParamId() {
        return userParamId;
    }

    public void setUserParamId(Long userParamId) {
        this.userParamId = userParamId;
    }
}
