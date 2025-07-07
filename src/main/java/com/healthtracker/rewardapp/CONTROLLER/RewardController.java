package com.healthtracker.rewardapp.CONTROLLER;

import com.healthtracker.rewardapp.DTO.RewardRequestDTO;
import com.healthtracker.rewardapp.Service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    @Autowired
    RewardService rewardService;

    @PostMapping
    public Double updateRewardData(@RequestBody RewardRequestDTO rewardRequestDTO){
        return rewardService.updateRewardData(rewardRequestDTO);
    }

    @GetMapping()
    public Double getUserRewardDataForMonthOrTotal(@RequestParam Long userId, @RequestParam(required = false) String monYear){
        if(monYear != null) {
            return rewardService.getUserRewardValueForMonthYear(userId, monYear);
        }else{
            return rewardService.getUserTotalRewardValue(userId);
        }
    }
}
