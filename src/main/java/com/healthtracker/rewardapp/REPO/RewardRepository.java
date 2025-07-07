package com.healthtracker.rewardapp.REPO;

import com.healthtracker.rewardapp.DAO.RewardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RewardRepository extends JpaRepository<RewardEntity, Long> {
    Optional<RewardEntity> findBykeyMonDDAndUserId(String keyMonDD, Long userId);

    List<RewardEntity> findByUserId(Long userId);
}
