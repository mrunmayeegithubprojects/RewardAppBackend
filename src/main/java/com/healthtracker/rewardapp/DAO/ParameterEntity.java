package com.healthtracker.rewardapp.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="parameters")
public class ParameterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paramId;

    @Column(nullable = false, unique = true)
    private String paramName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TrackingFrequency trackingFrequency;

    @Column(nullable = false)
    private Integer doneValue;

    @Column(nullable = false)
    private Integer notDoneValue;

    @Column(nullable = false)
    private String status;  // e.g. "active", "inactive"

    @OneToMany(mappedBy = "parameter", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<UserParamEntity> userParams = new ArrayList<>();

    public ParameterEntity() {
    }

    public List<UserParamEntity> getUserParams() {
        return userParams;
    }

    public void setUserParams(List<UserParamEntity> userParams) {
        this.userParams = userParams;
    }

    public Long getParamId() {
        return paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public TrackingFrequency getTrackingFrequency() {
        return trackingFrequency;
    }

    public void setTrackingFrequency(TrackingFrequency trackingFrequency) {
        this.trackingFrequency = trackingFrequency;
    }

    public Integer getDoneValue() {
        return doneValue;
    }

    public void setDoneValue(Integer doneValue) {
        this.doneValue = doneValue;
    }

    public Integer getNotDoneValue() {
        return notDoneValue;
    }

    public void setNotDoneValue(Integer notDoneValue) {
        this.notDoneValue = notDoneValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
