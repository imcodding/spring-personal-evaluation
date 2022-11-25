package com.imcd.evaluation.repository;

import com.imcd.evaluation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserId(String userId);
    Optional<User> findUserByUserIdAndPassword(String userId, String password);

    @Query("select u from User u where u.dept.deptNo = :deptNo and u.no not in :userNo")
    List<User> findTarget(@Param("deptNo") Long deptNo, @Param("userNo") Long userNo);
}
