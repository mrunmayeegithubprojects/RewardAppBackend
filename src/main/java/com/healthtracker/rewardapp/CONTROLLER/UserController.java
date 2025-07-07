package com.healthtracker.rewardapp.CONTROLLER;

import com.healthtracker.rewardapp.DTO.UserDTO;
import com.healthtracker.rewardapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers(){
    return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return  userService.getUserDetails(id);
    }
    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
