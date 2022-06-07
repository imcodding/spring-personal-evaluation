package com.imcd.evaluation.service;

import com.imcd.evaluation.dto.UserDto;
import com.imcd.evaluation.entity.User;
import com.imcd.evaluation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    @Transactional
    public void join(UserDto userDto) {
        userRepository.save(UserDto.toEntity(userDto));
    }
}
