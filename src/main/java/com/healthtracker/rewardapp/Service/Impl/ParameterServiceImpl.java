package com.healthtracker.rewardapp.Service.Impl;

import com.healthtracker.rewardapp.DAO.ParameterEntity;
import com.healthtracker.rewardapp.DTO.ParameterDTO;
import com.healthtracker.rewardapp.REPO.ParameterRepository;
import com.healthtracker.rewardapp.Service.ParameterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ParameterRepository parameterRepository;

    @Override
    public ParameterDTO createParameter(ParameterDTO parameter) {
        ParameterEntity parameterEntity = modelMapper.map(parameter, ParameterEntity.class);
        parameterEntity.setStatus("active");
        return modelMapper.map(parameterRepository.save(parameterEntity), ParameterDTO.class);
    }

    @Override
    public ParameterDTO getParameterById(Long id) {
        return modelMapper.map(parameterRepository.findById(id), ParameterDTO.class);
    }

    @Override
    public List<ParameterDTO> getAllParameters() {
        List<ParameterDTO> parameterDTOList = new ArrayList<>();
        for(ParameterEntity parameterEntity : parameterRepository.findAll()){
            parameterDTOList.add(modelMapper.map(parameterEntity, ParameterDTO.class));
        }
        return parameterDTOList;
    }

    @Override
    public void deleteParamter(Long id) {
        parameterRepository.deleteById(id);;
    }
    @Override
    public ParameterDTO updateParameter(Long id,ParameterDTO parameter) {
        ParameterEntity parameterEntity = parameterRepository.findById(id).orElseThrow(() -> new RuntimeException("Parameter not found with id: "+id));
        modelMapper.map(parameter,parameterEntity);
        parameterEntity.setParamId(id);
        parameterEntity.setStatus("active");
        return modelMapper.map(parameterRepository.save(parameterEntity), ParameterDTO.class);
    }
}
