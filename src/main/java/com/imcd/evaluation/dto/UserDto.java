package com.imcd.evaluation.dto;

import com.imcd.evaluation.code.Role;
import com.imcd.evaluation.code.Status;
import com.imcd.evaluation.entity.User;
import lombok.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long no;
    private String userId;
    private String password;
    private String name;
    private String position;
    private String dept;
    private Role role;
    private List<TargetDto> targets = new ArrayList<>();

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .no(user.getNo())
                .userId(user.getUserId())
                .name(user.getName())
                .dept(user.getDept())
                .position(user.getPosition())
                .build();
    }

    public static User toEntity(UserDto userDto) {
        return User.builder()
                .no(userDto.getNo())
                .userId(userDto.getUserId())
//                .password(passwordSHA256(userDto.getPassword()))
                .name(userDto.getName())
                .dept(userDto.getDept())
                .position(userDto.getPosition())
                .role(Role.EMPLOYEE)
                .submitStatus(Status.DONT)
                .build();
    }

    public static String passwordSHA256(String password) {
        //TODO 추후 spring security 적용
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            return String.format("%064x", new BigInteger(1, md.digest()));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
