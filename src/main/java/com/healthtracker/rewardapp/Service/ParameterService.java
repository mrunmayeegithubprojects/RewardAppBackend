package com.healthtracker.rewardapp.Service;

import com.healthtracker.rewardapp.DAO.ParameterEntity;
import com.healthtracker.rewardapp.DTO.ParameterDTO;

import java.util.List;

public interface ParameterService {
    ParameterDTO createParameter(ParameterDTO parameter);
    ParameterDTO getParameterById(Long id);
    List<ParameterDTO> getAllParameters();
    void deleteParamter(Long id);
    ParameterDTO updateParameter(Long id, ParameterDTO parameter);
}
