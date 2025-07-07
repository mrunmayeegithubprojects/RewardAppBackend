package com.healthtracker.rewardapp.CONTROLLER;

import com.healthtracker.rewardapp.DTO.DailyDTO;
import com.healthtracker.rewardapp.DTO.UserParameterRequestDTO;
import com.healthtracker.rewardapp.Service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/daily")
public class DailyController {
    @Autowired
    DailyService dailyService;

    @PostMapping
    public void updateDailyUserParameters(@RequestBody List<DailyDTO> dailyDTO){
        dailyService.setUserAndParameterDailyDetails(dailyDTO);
    }

    @GetMapping
    public List<DailyDTO> getUserParametersDailyDetails(@RequestParam Long userId, @RequestParam LocalDate date){
        return dailyService.getUserParameterDailyDetails(userId, date);
    }
}
