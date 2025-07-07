package com.healthtracker.rewardapp.DTO;

import com.healthtracker.rewardapp.DAO.TrackingFrequency;
import io.swagger.v3.oas.annotations.media.Schema;

public class ParameterDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long paramId;
    private String paramName;
    private TrackingFrequency trackingFrequency;
    private Integer doneValue;
    private Integer notDoneValue;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String status;

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
