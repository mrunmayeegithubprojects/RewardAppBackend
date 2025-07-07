package com.healthtracker.rewardapp.REPO;

import com.healthtracker.rewardapp.DAO.DailyEntity;
import com.healthtracker.rewardapp.DAO.MonthlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DailyRepository extends JpaRepository<DailyEntity, Long> {

    Optional<DailyEntity> findByUserParamIdAndDate(Long userParamId, LocalDate date);

    @Query("SELECT d FROM DailyEntity d WHERE d.userId = :userId AND MONTH(d.date) = :month AND YEAR(d.date) = :year")
    List<DailyEntity> findByUserIdAndMonthAndYear(@Param("userId") Long userParamId,@Param("month") int month,@Param("year") int year);


}
