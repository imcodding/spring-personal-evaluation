package com.imcd.evaluation.repository;

import com.imcd.evaluation.entity.Target;
import com.imcd.evaluation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TargetRepository extends JpaRepository<Target, Long> {

    @Query("select u from User u, Target t where u.userId = t.targetId")
    List<User> findTargetByUser();
}
