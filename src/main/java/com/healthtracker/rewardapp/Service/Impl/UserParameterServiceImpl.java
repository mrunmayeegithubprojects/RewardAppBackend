package com.healthtracker.rewardapp.Service.Impl;

import com.healthtracker.rewardapp.DAO.TrackingFrequency;
import com.healthtracker.rewardapp.DAO.UserEntity;
import com.healthtracker.rewardapp.DAO.UserParamEntity;
import com.healthtracker.rewardapp.DTO.ParameterDTO;
import com.healthtracker.rewardapp.DTO.UserParameterRequestDTO;
import com.healthtracker.rewardapp.DTO.UserParameterResponseDTO;
import com.healthtracker.rewardapp.REPO.ParameterRepository;
import com.healthtracker.rewardapp.REPO.UserParamRepository;
import com.healthtracker.rewardapp.REPO.UserRepository;
import com.healthtracker.rewardapp.Service.UserParameterService;
import com.healthtracker.rewardapp.Utility.Mapper.UserParameterMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserParameterServiceImpl implements UserParameterService {

    @Autowired
    UserParamRepository userParamRepository;

    @Autowired
    ParameterRepository parameterRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void setUserAndParameterDetails(UserParameterRequestDTO userParameterRequestDTO) {
        Set<Long> parameterIDsCurrent = new HashSet<>();
        //capturing a Map of parameter ID and its corresponding userParam ID
        Map<Long,Long> paramIdAndUserParamIdMap = new HashMap<>();
        for(UserParamEntity userParamEntity : getListOfActiveUserParameters(userParameterRequestDTO.getUserId())){
            parameterIDsCurrent.add(userParamEntity.getParameterId());
            paramIdAndUserParamIdMap.put(userParamEntity.getParameterId(), userParamEntity.getUserParamId());
        }
        Set<Long> parameterIdsMarkInactiveSet = new HashSet<>(parameterIDsCurrent);
        parameterIdsMarkInactiveSet.removeAll(userParameterRequestDTO.getParameterIds());
        Set<Long> parameterIdsAddNew = new HashSet<>(userParameterRequestDTO.getParameterIds());
        parameterIdsAddNew.removeAll(parameterIDsCurrent);

        List<UserParamEntity> userParamEntityList_toBeMarkedInactive = UserParameterMapper.UserParameterRequestDTOToEntity(userParameterRequestDTO.getUserId(), parameterIdsMarkInactiveSet, "inactive");
        for(UserParamEntity userParamEntity: userParamEntityList_toBeMarkedInactive){
            userParamEntity.setUserParamId(paramIdAndUserParamIdMap.get(userParamEntity.getParameterId()));
        }
        List<UserParamEntity> userParamEntityList_toBeMarkedActive = UserParameterMapper.UserParameterRequestDTOToEntity(userParameterRequestDTO.getUserId(), parameterIdsAddNew, "active");
        userParamRepository.saveAll(userParamEntityList_toBeMarkedInactive);
        userParamRepository.saveAll(userParamEntityList_toBeMarkedActive);
    }

    @Override
    public UserParameterResponseDTO getAllActiveParametersByUser(Long userId) {
        List<UserParamEntity> activeUserParams = getListOfActiveUserParameters(userId);
        UserParameterResponseDTO userParameterResponseDTO = new UserParameterResponseDTO();
        userParameterResponseDTO.setUserName(userRepository.findById(userId).map(UserEntity::getName).orElse(null));
        List<ParameterDTO> parameterDTOList = new ArrayList<>();
        for(UserParamEntity userParamEntity : activeUserParams){
            parameterDTOList.add(modelMapper.map(parameterRepository.findById(userParamEntity.getParameterId()), ParameterDTO.class));
        }
        userParameterResponseDTO.setParameterDTOList(parameterDTOList);
        return userParameterResponseDTO;
    }

    @Override
    public List<ParameterDTO> getAllActiveParametersByUserAndTrackingFreq(Long userId, String trackingFrequency) {
        return getAllActiveParametersByUser(userId).getParameterDTOList().stream()
                .filter(p ->  (trackingFrequency.equalsIgnoreCase("daily")?TrackingFrequency.DAILY:TrackingFrequency.MONTHLY)== p.getTrackingFrequency())
                .collect(Collectors.toList());
    }

    private List<UserParamEntity> getListOfActiveUserParameters(Long userId){
        return userParamRepository.findAllByUserIdAndStatus(userId, "active");
    }
}
