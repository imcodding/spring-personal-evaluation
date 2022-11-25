package com.imcd.evaluation;

import com.imcd.evaluation.code.*;
import com.imcd.evaluation.dto.DeptDto;
import com.imcd.evaluation.dto.UserDto;
import com.imcd.evaluation.entity.Dept;
import com.imcd.evaluation.entity.User;
import com.imcd.evaluation.repository.DeptRepository;
import com.imcd.evaluation.repository.TargetRepository;
import com.imcd.evaluation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TestInitData {

    private final UserRepository userRepository;
    private final TargetRepository targetRepository;
    private final DeptRepository deptRepository;

    @PostConstruct
    public void init() {

        Dept dept = Dept.builder().name("웹플랫폼팀").build();
        deptRepository.save(dept);
        deptRepository.save(Dept.builder().name("서버1팀").build());
        deptRepository.save(Dept.builder().name("서버2팀").build());
        deptRepository.save(Dept.builder().name("디자인팀").build());

        userRepository.save(
                User.builder()
                        .no(1L)
                        .userId("test")
                        .password("test")
                        .name("홍길동")
                        .position("사원")
                        .dept(dept)
                        .submitStatus(Status.DONT)
                        .role(Role.EMPLOYEE)
                        .build()
        );

        userRepository.save(
                User.builder()
                        .no(2L)
                        .userId("test2")
                        .password("test")
                        .name("이몽룡")
                        .position("사원")
                        .dept(dept)
                        .submitStatus(Status.DONT)
                        .role(Role.EMPLOYEE)
                        .build()
        );

        userRepository.save(
                User.builder()
                        .no(3L)
                        .userId("test3")
                        .password("test")
                        .name("아무개")
                        .position("대표")
                        .dept(dept)
                        .submitStatus(Status.DONT)
                        .role(Role.ADMIN)
                        .build()
        );

        List<User> users = userRepository.findTarget(1L, 1L);
    }

    public static List<SelectCode> getPositionList() {
        List<SelectCode> positionList = new ArrayList<>();
        positionList.add(new SelectCode("SW", "사원"));
        positionList.add(new SelectCode("DR", "대리"));
        positionList.add(new SelectCode("GJ", "과장"));
        positionList.add(new SelectCode("CJ", "차장"));
        positionList.add(new SelectCode("BJ", "부장"));
        positionList.add(new SelectCode("BBJ", "본부장"));
        return positionList;
    }

    public static List<SelectCode> getDeptList() {
        List<SelectCode> deptList = new ArrayList<>();
        deptList.add(new SelectCode("WEB", "웹플랫폼팀"));
        deptList.add(new SelectCode("SERVER1", "서버1팀"));
        deptList.add(new SelectCode("SERVER2", "서버2팀"));
        deptList.add(new SelectCode("DESIGN", "디자인팀"));
        return deptList;
    }

    public static List<SelectCode> getScoreSelectList() {
        List<SelectCode> scoreList = new ArrayList<>();
        scoreList.add(new SelectCode(1, "미흡"));
        scoreList.add(new SelectCode(2, "보통"));
        scoreList.add(new SelectCode(3, "좋음"));
        scoreList.add(new SelectCode(4, "우수"));
        scoreList.add(new SelectCode(5, "최고"));
        return scoreList;
    }

    public static List<SelectCode> getScoreTypeList() {
        List<SelectCode> typeList = new ArrayList<>();
        typeList.add(new SelectCode("passionScore", "열정"));
        typeList.add(new SelectCode("faithScore", "신념"));
        typeList.add(new SelectCode("responsibilityScore", "책임감"));
        typeList.add(new SelectCode("harmonyScore", "조화"));
        typeList.add(new SelectCode("processingScore", "업무처리"));
        typeList.add(new SelectCode("customerScore", "고객대응"));
        typeList.add(new SelectCode("leadershipScore", "리더십"));
        typeList.add(new SelectCode("expertScore", "전문지식"));
        return typeList;
    }

    public static List<UserDto> getTargetList() {
        List<UserDto> users = new ArrayList<>();
        users.add(new UserDto());
        users.add(new UserDto());
        users.add(new UserDto());
        users.add(new UserDto());
        users.add(new UserDto());
        return users;
    }
}
