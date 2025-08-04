package com.healthtracker.rewardapp.Service.Impl;

import com.healthtracker.rewardapp.Config.Constants;
import com.healthtracker.rewardapp.DAO.UserEntity;
import com.healthtracker.rewardapp.DTO.UserDTO;
import com.healthtracker.rewardapp.REPO.UserRepository;
import com.healthtracker.rewardapp.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.healthtracker.rewardapp.Config.Constants.STATUS_ACTIVE;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        for(UserEntity userEntity : userRepository.findAll()){
            userDTOList.add(modelMapper.map(userEntity, UserDTO.class));
        }
        return userDTOList;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO,UserEntity.class);
        userEntity.setStatus(STATUS_ACTIVE);
        return modelMapper.map(userRepository.save(userEntity), UserDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
    userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserDetails(Long id) {
        return modelMapper.map(userRepository.findById(id),UserDTO.class);
    }
}
