package com.healthtracker.rewardapp.REPO;

import com.healthtracker.rewardapp.DAO.MonthlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MonthlyRepository extends JpaRepository<MonthlyEntity, Long> {

    @Query("SELECT m FROM MonthlyEntity m WHERE m.userParamId = :userParamId AND MONTH(m.date) = :month AND YEAR(m.date) = :year")
    Optional<MonthlyEntity> findByUserParamIdAndMonthAndYear(
            @Param("userParamId") Long userParamId,
            @Param("month") int month,
            @Param("year") int year
    );

    @Query("SELECT m FROM MonthlyEntity m WHERE m.userId = :userId AND MONTH(m.date) = :month AND YEAR(m.date) = :year")
    List<MonthlyEntity> findByUserIdAndMonthAndYear(
            @Param("userId") Long userId,
            @Param("month") int month,
            @Param("year") int year
    );
}
