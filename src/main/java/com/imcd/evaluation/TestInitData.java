package com.imcd.evaluation;

import com.imcd.evaluation.code.*;
import com.imcd.evaluation.entity.User;
import com.imcd.evaluation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TestInitData {

    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.save(
                new User(1L, "test", "test",
                "홍길동", "사원", "웹팀",
                Status.DONT, Role.EMPLOYEE, new ArrayList<>())
        );
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
}
