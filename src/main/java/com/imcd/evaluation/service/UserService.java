package com.imcd.evaluation.service;

import com.imcd.evaluation.dto.UserDto;
import com.imcd.evaluation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getUserList() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    public List<UserDto> getTargetList(Long deptNo, Long userNo) {
        return userRepository.findTarget(deptNo, userNo)
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }
}
