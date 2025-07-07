package com.healthtracker.rewardapp.DTO;

import java.util.List;

public class UserParameterResponseDTO {
    private String userName;
    private List<ParameterDTO> parameterDTOList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ParameterDTO> getParameterDTOList() {
        return parameterDTOList;
    }

    public void setParameterDTOList(List<ParameterDTO> parameterDTOList) {
        this.parameterDTOList = parameterDTOList;
    }
}
