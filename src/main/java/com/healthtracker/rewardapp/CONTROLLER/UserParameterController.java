package com.healthtracker.rewardapp.CONTROLLER;

import com.healthtracker.rewardapp.DTO.ParameterDTO;
import com.healthtracker.rewardapp.DTO.UserParameterRequestDTO;
import com.healthtracker.rewardapp.DTO.UserParameterResponseDTO;
import com.healthtracker.rewardapp.Service.UserParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userParameter")
public class UserParameterController {

    @Autowired
    UserParameterService userParameterService;
@PostMapping
    public void assignUserParameters(@RequestBody UserParameterRequestDTO userParameterRequestDTO){
    userParameterService.setUserAndParameterDetails(userParameterRequestDTO);
}

@GetMapping("/{userId}")
    public UserParameterResponseDTO getAllActiveUserParameters(@PathVariable Long userId){
    return userParameterService.getAllActiveParametersByUser(userId);
}

@GetMapping
    public List<ParameterDTO> getAllActiveUserParametersByUserIdAndTrackingFre(@RequestParam Long userId, @RequestParam String trackingFrequency){
    return userParameterService.getAllActiveParametersByUserAndTrackingFreq(userId, trackingFrequency);
}

}
