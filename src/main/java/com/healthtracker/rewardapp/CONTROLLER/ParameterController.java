package com.healthtracker.rewardapp.CONTROLLER;

import com.healthtracker.rewardapp.DAO.ParameterEntity;
import com.healthtracker.rewardapp.DTO.ParameterDTO;
import com.healthtracker.rewardapp.REPO.ParameterRepository;
import com.healthtracker.rewardapp.Service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parameters")
public class ParameterController {
    @Autowired private ParameterService parameterService;

    //create a new parameter
    @PostMapping
    public ParameterDTO createParameter (@RequestBody ParameterDTO parameter){
        return parameterService.createParameter(parameter);
    }

    //get All Parameters
    @GetMapping
    public List<ParameterDTO> getAllParameter(){
        return parameterService.getAllParameters();
    }

    //get parameter by id
    @GetMapping("/{id}")
    public  ParameterDTO getParameterById(@PathVariable Long id){
        return parameterService.getParameterById(id);
    }

    //update a parameter
    @PutMapping("/{id}")
    public ParameterDTO updateParameter(@PathVariable Long id, @RequestBody ParameterDTO updatedParam){
        return parameterService.updateParameter(id, updatedParam);
    }

    //delete a parameter
    @DeleteMapping("/{id}")
    public void deleteParameter(@PathVariable Long id){
        parameterService.deleteParamter(id);
    }
}
