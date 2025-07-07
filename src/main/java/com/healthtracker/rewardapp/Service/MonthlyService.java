package com.healthtracker.rewardapp.Service;

import com.healthtracker.rewardapp.DTO.DailyDTO;
import com.healthtracker.rewardapp.DTO.MonthlyDTO;

import java.time.LocalDate;
import java.util.List;


public interface MonthlyService {
    void setUserAndParameterMonthlyDetails(List<MonthlyDTO> monthlyDTOList);

    List<MonthlyDTO> getUserParameterMonthlyDetails(Long userId, LocalDate date);
}
