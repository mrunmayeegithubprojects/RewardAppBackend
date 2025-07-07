package com.healthtracker.rewardapp.REPO;

import com.healthtracker.rewardapp.DAO.UserParamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserParamRepository extends JpaRepository<UserParamEntity, Long> {
    List<UserParamEntity> findAllByUserIdAndStatus(Long userId, String active);
    List<UserParamEntity> findAllByParameterId(Long parameterId);
    @Query("SELECT u.userParamId FROM UserParamEntity u WHERE u.parameterId = :paramId and u.userId = :userId")
    Long findUserParamIdByParameterIdAndUserId(@Param("paramId") Long paramId, @Param("userId") Long userId);

    @Query("SELECT u.parameterId FROM UserParamEntity u WHERE u.userParamId = :userParamId")
    Long findParameterIdByUserParamId(@Param("userParamId") Long userParamId);

}
