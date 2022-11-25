package com.imcd.evaluation.repository;

import com.imcd.evaluation.entity.Target;
import com.imcd.evaluation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TargetRepository extends JpaRepository<Target, Long> {

//    @Query("select u from User u, Target t where u.userId = t.targetId and t.user.no = :userNo")
//    List<User> findTargetByUser(@Param("userNo") Long userNo);
//
//    @Query("select t from User u left join Target t on u.userId = t.targetId")
//    List<Target> findTargetList();


}
