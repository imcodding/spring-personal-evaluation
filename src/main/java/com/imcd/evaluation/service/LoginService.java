package com.imcd.evaluation.service;

import com.imcd.evaluation.code.ErrorCode;
import com.imcd.evaluation.dto.UserDto;
import com.imcd.evaluation.entity.User;
import com.imcd.evaluation.exception.ErrorException;
import com.imcd.evaluation.exception.JwtRuntimeException;
import com.imcd.evaluation.jwt.provider.JwtAuthProvider;
import com.imcd.evaluation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JwtAuthProvider jwtAuthProvider;

    @Transactional
    public void join(UserDto userDto) {
        userRepository.save(UserDto.toEntity(userDto));
    }

    public UserDto login(UserDto userDto, HttpServletResponse response) {
        Optional<User> user = userRepository.findUserByUserIdAndPassword(
                userDto.getUserId(),
                userDto.getPassword()
//                UserDto.passwordSHA256(userDto.getPassword())
        );

        if(user.isEmpty()) throw new ErrorException(ErrorCode.NO_USER);

        Optional<String> token = jwtAuthProvider.createJwtAuthToken(user.get().getUserId(), user.get().getRole());

        if(token.isPresent()) {
            Cookie cookie = new Cookie("JWT_TOKEN", token.get());
            response.addCookie(cookie);
        }

        return UserDto.fromEntity(user.get());
    }
}
