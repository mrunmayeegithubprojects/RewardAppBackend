package com.healthtracker.rewardapp.Service.Impl;

import com.healthtracker.rewardapp.DAO.DailyEntity;
import com.healthtracker.rewardapp.DAO.MonthlyEntity;
import com.healthtracker.rewardapp.DAO.ParameterEntity;
import com.healthtracker.rewardapp.DAO.UserParamEntity;
import com.healthtracker.rewardapp.DTO.DailyDTO;
import com.healthtracker.rewardapp.DTO.MonthlyDTO;
import com.healthtracker.rewardapp.REPO.DailyRepository;
import com.healthtracker.rewardapp.REPO.MonthlyRepository;
import com.healthtracker.rewardapp.REPO.ParameterRepository;
import com.healthtracker.rewardapp.REPO.UserParamRepository;
import com.healthtracker.rewardapp.Service.DailyService;
import com.healthtracker.rewardapp.Service.MonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MonthlyServiceImpl implements MonthlyService {
    @Autowired
    UserParamRepository userParamRepository;

    @Autowired
    ParameterRepository parameterRepository;

    @Autowired
    MonthlyRepository monthlyRepository;

    @Override
    public void setUserAndParameterMonthlyDetails(List<MonthlyDTO> monthlyDTOList) {
        for (MonthlyDTO monthlyDTO : monthlyDTOList) {
            Long userParamId = userParamRepository.findUserParamIdByParameterIdAndUserId(monthlyDTO.getParamId(), monthlyDTO.getUserId());
            Optional<ParameterEntity> parameterEntity = parameterRepository.findById(monthlyDTO.getParamId());
            int doneVal = parameterEntity.get().getDoneValue();
            int notDoneVal = parameterEntity.get().getNotDoneValue();
            int rewardVal = monthlyDTO.getMetFlag() ? doneVal : -(notDoneVal);
            MonthlyEntity monthlyEntity;
            Optional<MonthlyEntity> monthly = monthlyRepository.findByUserParamIdAndMonthAndYear(userParamId, monthlyDTO.getDate().getMonthValue(), monthlyDTO.getDate().getYear());
            if (monthly.isPresent()) {
                monthlyEntity = monthly.get();
                monthlyEntity.setRewardVal(rewardVal);
                monthlyEntity.setMetFlag(monthlyDTO.getMetFlag());
            } else {
                monthlyEntity = new MonthlyEntity();
                monthlyEntity.setUserParamId(userParamId);
                monthlyEntity.setRewardVal(rewardVal);
                monthlyEntity.setDate(monthlyDTO.getDate());
                monthlyEntity.setMetFlag(monthlyDTO.getMetFlag());
                monthlyEntity.setUserId(monthlyDTO.getUserId());
            }
            monthlyRepository.save(monthlyEntity);
        }
    }

    @Override
    public List<MonthlyDTO> getUserParameterMonthlyDetails(Long userId, LocalDate date) {
        List<Long> userParamIdList = userParamRepository.findAllByUserIdAndStatus(userId, "active")
                .stream()
                .map(UserParamEntity::getUserParamId)
                .collect(Collectors.toList());
        List<MonthlyDTO> monthlyDTOS = new ArrayList<>();
        for (Long uLong : userParamIdList) {
            Optional<MonthlyEntity> monthlyEntity = monthlyRepository.findByUserParamIdAndMonthAndYear(uLong, date.getMonthValue(), date.getYear());
            if (monthlyEntity.isPresent()) {
                MonthlyDTO monthlyDTO = new MonthlyDTO();
                monthlyDTO.setMonthlyId(monthlyEntity.get().getMonthlyId());
                monthlyDTO.setUserId(userId);
                monthlyDTO.setParamId(userParamRepository.findParameterIdByUserParamId(uLong));
                monthlyDTO.setDate(date);
                monthlyDTO.setMetFlag(monthlyEntity.get().getMetFlag());
                monthlyDTOS.add(monthlyDTO);
            }
        }
        return monthlyDTOS;
    }
}
