package com.healthtracker.rewardapp.Service;

import com.healthtracker.rewardapp.DTO.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    void deleteUser(Long id);

    UserDTO getUserDetails(Long id);
}
