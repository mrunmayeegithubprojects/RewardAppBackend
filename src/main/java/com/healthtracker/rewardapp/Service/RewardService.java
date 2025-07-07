package com.healthtracker.rewardapp.Service;

import com.healthtracker.rewardapp.DTO.RewardRequestDTO;


public interface RewardService {

    Double updateRewardData(RewardRequestDTO rewardRequestDTO);

    Double getUserRewardValueForMonthYear(Long userId, String monYear);

    Double getUserTotalRewardValue(Long userId);
}
