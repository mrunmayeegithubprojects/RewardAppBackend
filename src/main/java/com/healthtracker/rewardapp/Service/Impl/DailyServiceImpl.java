package com.healthtracker.rewardapp.Service.Impl;

import com.healthtracker.rewardapp.DAO.DailyEntity;
import com.healthtracker.rewardapp.DAO.ParameterEntity;
import com.healthtracker.rewardapp.DAO.UserParamEntity;
import com.healthtracker.rewardapp.DTO.DailyDTO;
import com.healthtracker.rewardapp.REPO.DailyRepository;
import com.healthtracker.rewardapp.REPO.MonthlyRepository;
import com.healthtracker.rewardapp.REPO.ParameterRepository;
import com.healthtracker.rewardapp.REPO.UserParamRepository;
import com.healthtracker.rewardapp.Service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DailyServiceImpl implements DailyService {

    @Autowired
    DailyRepository dailyRepository;

    @Autowired
    MonthlyRepository monthlyRepository;

    @Autowired
    UserParamRepository userParamRepository;

    @Autowired
    ParameterRepository parameterRepository;

    @Override
    public void setUserAndParameterDailyDetails(List<DailyDTO> dailyDTO) {
        for (DailyDTO dailyDTO1 : dailyDTO) {
            Long userParamId = userParamRepository.findUserParamIdByParameterIdAndUserId(dailyDTO1.getParamId(), dailyDTO1.getUserId());
            Optional<ParameterEntity> parameterEntity = parameterRepository.findById(dailyDTO1.getParamId());
            int rewardVal;
            if(!dailyDTO1.getSkipFlag()) {
                int doneVal = parameterEntity.get().getDoneValue();
                int notDoneVal = parameterEntity.get().getNotDoneValue();
                rewardVal = dailyDTO1.getMetFlag() ? doneVal : -(notDoneVal);
            }else{
                rewardVal = 0;
            }
            DailyEntity dailyEntity1;
            Optional<DailyEntity> daily = dailyRepository.findByUserParamIdAndDate(userParamId, dailyDTO1.getDate());
            if (daily.isPresent()) {
                dailyEntity1 = daily.get();
                dailyEntity1.setRewardVal(rewardVal);
                dailyEntity1.setMetFlag(dailyDTO1.getMetFlag());
            } else {
                dailyEntity1 = new DailyEntity();
                dailyEntity1.setUserParamId(userParamId);
                dailyEntity1.setRewardVal(rewardVal);
                dailyEntity1.setDate(dailyDTO1.getDate());
                dailyEntity1.setMetFlag(dailyDTO1.getMetFlag());
                dailyEntity1.setUserId(dailyDTO1.getUserId());
            }
            dailyRepository.save(dailyEntity1);
        }
    }

    @Override
    public List<DailyDTO> getUserParameterDailyDetails(Long userId, LocalDate date) {
        List<Long> userParamIdList = userParamRepository.findAllByUserIdAndStatus(userId, "active")
                .stream()
                .map(UserParamEntity::getUserParamId)
                .collect(Collectors.toList());
        List<DailyDTO> dailyDTOList = new ArrayList<>();
        for (Long uLong : userParamIdList) {
            Optional<DailyEntity> dailyEntity = dailyRepository.findByUserParamIdAndDate(uLong, date);
            if (dailyEntity.isPresent()) {
                DailyDTO dailyDTO = new DailyDTO();
                dailyDTO.setDailyId(dailyEntity.get().getDailyId());
                dailyDTO.setUserId(userId);
                dailyDTO.setParamId(userParamRepository.findParameterIdByUserParamId(uLong));
                dailyDTO.setDate(date);
                dailyDTO.setMetFlag(dailyEntity.get().getMetFlag());
                dailyDTOList.add(dailyDTO);
            }
        }
        return dailyDTOList;
    }

    @Override
    public Map<Long, Double> getCurrentMonthStandings(LocalDate date) {
        LocalDate firstDay = date.withDayOfMonth(1);
        LocalDate lastDay = date.withDayOfMonth(date.lengthOfMonth());

        // 2. Query DB
        List<Object[]> dailyResults = dailyRepository.getMonthlyRewardSums(firstDay, lastDay);
        List<Object[]> monthlyResults = monthlyRepository.getMonthlyRewardSums(firstDay, lastDay);

        Map<Long, Double> totalRewards = new HashMap<>();

// Daily rewards processing
        for (Object[] row : dailyResults) {
            Long userId = (Long) row[0];
            Number reward = (Number) row[1];
            totalRewards.put(userId, reward.doubleValue());
        }

// Monthly rewards processing (merge into same map)
        for (Object[] row : monthlyResults) {
            Long userId = (Long) row[0];
            Number reward = (Number) row[1];
            totalRewards.merge(userId, reward.doubleValue(), Double::sum);
        }

        return totalRewards;
    }

}
