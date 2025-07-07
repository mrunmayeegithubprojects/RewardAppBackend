package com.healthtracker.rewardapp.CONTROLLER;

import com.healthtracker.rewardapp.DTO.DailyDTO;
import com.healthtracker.rewardapp.DTO.MonthlyDTO;
import com.healthtracker.rewardapp.Service.DailyService;
import com.healthtracker.rewardapp.Service.MonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/monthly")
public class MonthlyController {
    @Autowired
    MonthlyService monthlyService;

    @PostMapping
    public void updateMonthlyUserParameters(@RequestBody List<MonthlyDTO> monthlyDTOList){
        monthlyService.setUserAndParameterMonthlyDetails(monthlyDTOList);
    }

    @GetMapping
    public List<MonthlyDTO> getUserParametersMonthlyDetails(@RequestParam Long userId, @RequestParam LocalDate date){
        return monthlyService.getUserParameterMonthlyDetails(userId, date);
    }
}
