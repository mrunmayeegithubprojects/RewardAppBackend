package com.healthtracker.rewardapp.Service;

import com.healthtracker.rewardapp.DTO.ParameterDTO;
import com.healthtracker.rewardapp.DTO.UserParameterRequestDTO;
import com.healthtracker.rewardapp.DTO.UserParameterResponseDTO;

import java.util.List;

public interface UserParameterService {
    void setUserAndParameterDetails(UserParameterRequestDTO userParameterRequestDTO);

    UserParameterResponseDTO getAllActiveParametersByUser(Long userId);

    List<ParameterDTO> getAllActiveParametersByUserAndTrackingFreq(Long userId, String trackingFrequency);
}
