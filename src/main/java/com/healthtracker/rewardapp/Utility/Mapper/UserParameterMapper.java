package com.healthtracker.rewardapp.Utility.Mapper;

import com.healthtracker.rewardapp.DAO.UserParamEntity;
import com.healthtracker.rewardapp.DTO.UserParameterRequestDTO;
import com.healthtracker.rewardapp.REPO.UserParamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserParameterMapper {
    //DTO --> Entity
    public static List<UserParamEntity> UserParameterRequestDTOToEntity(Long userId, Set<Long> parameterIdList, String status) {
        List<UserParamEntity> userParamEntityList = new ArrayList<>();
        for(Long parameterId : parameterIdList){
            UserParamEntity userParamEntity = new UserParamEntity();
            userParamEntity.setUser();setUserId(userId);
            userParamEntity.setParameter(parameterId);
            userParamEntity.setStatus(status);
            userParamEntityList.add(userParamEntity);
        }
        return userParamEntityList;
    }
}
