package com.healthtracker.rewardapp.Service;

import com.healthtracker.rewardapp.DTO.DailyDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface DailyService {
    void setUserAndParameterDailyDetails(List<DailyDTO> dailyDTO);

    List<DailyDTO> getUserParameterDailyDetails(Long userId, LocalDate date);

    Map<Long, Double> getCurrentMonthStandings(LocalDate date);
}
