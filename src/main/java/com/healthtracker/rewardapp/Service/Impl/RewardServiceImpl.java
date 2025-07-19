package com.healthtracker.rewardapp.Service.Impl;

import com.healthtracker.rewardapp.DAO.*;
import com.healthtracker.rewardapp.DTO.RewardRequestDTO;
import com.healthtracker.rewardapp.REPO.*;
import com.healthtracker.rewardapp.Service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    RewardRepository rewardRepository;

    @Autowired
    DailyRepository dailyRepository;

    @Autowired
    MonthlyRepository monthlyRepository;

    @Override
    public Double updateRewardData(RewardRequestDTO rewardRequestDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        String key = rewardRequestDTO.getKey().contains("RewardConsumed_")?rewardRequestDTO.getKey().split("_")[1]:rewardRequestDTO.getKey();
        YearMonth ym = YearMonth.parse(key, formatter);
        RewardEntity rewardEntity = new RewardEntity();
        rewardEntity.setKeyMonDD(rewardRequestDTO.getKey());
        rewardEntity.setUserId(rewardRequestDTO.getUserId());
        Double rewardPoints = null;
        if (rewardRequestDTO.getRewardAdjustment() != null) {
            rewardEntity.setRewardPoints(-rewardRequestDTO.getRewardAdjustment());
        } else {
            //adding value of monthly parameter rewards for user
            rewardPoints = monthlyRepository.findByUserIdAndMonthAndYear(rewardRequestDTO.getUserId(), ym.getMonthValue(), ym.getYear()).stream().mapToDouble(MonthlyEntity::getRewardVal).sum();
            //adding value of daily parameter rewards for user
            rewardPoints += dailyRepository.findByUserIdAndMonthAndYear(rewardRequestDTO.getUserId(), ym.getMonthValue(), ym.getYear()).stream().mapToDouble(DailyEntity::getRewardVal).sum();
            rewardEntity.setRewardPoints(rewardPoints);
        }
        rewardRepository.save(rewardEntity);
        return rewardPoints;
    }

    @Override
    public Double getUserRewardValueForMonthYear(Long userId, String monYear) {
            return rewardRepository.findBykeyMonDDAndUserId(monYear, userId).map(RewardEntity::getRewardPoints).orElse(null);
    }

    @Override
    public Double getUserTotalRewardValue(Long userId) {
        return rewardRepository.findByUserId(userId).stream().mapToDouble(RewardEntity::getRewardPoints).sum();
    }
}
