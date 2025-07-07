package com.healthtracker.rewardapp.REPO;

import com.healthtracker.rewardapp.DAO.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
