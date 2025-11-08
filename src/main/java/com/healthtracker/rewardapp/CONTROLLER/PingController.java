package com.healthtracker.rewardapp.CONTROLLER;

import com.healthtracker.rewardapp.REPO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
    @RestController
    public class PingController {
        @Autowired
        private UserRepository userRepository;

         @GetMapping("/api/ping")
         public String ping() {
// //            long userCount = userRepository.count();  // lightweight DB call
// //            return "pong - users in DB: " + userCount;
             return "Test";
         }
    }
