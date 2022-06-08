package com.imcd.evaluation.repository;

import com.imcd.evaluation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserId(String userId);
    Optional<User> findUserByUserIdAndPassword(String userId, String password);
}
