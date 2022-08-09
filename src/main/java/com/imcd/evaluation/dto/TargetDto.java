package com.imcd.evaluation.dto;

import com.imcd.evaluation.entity.Score;
import com.imcd.evaluation.entity.Target;
import com.imcd.evaluation.entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TargetDto {

    private Long targetNo;
    private UserDto user;
    private String targetId;
    private List<Score> scores = new ArrayList<>();

    public static Target toEntity(TargetDto targetDto) {
        return Target.builder()
                .targetId(targetDto.getTargetId())
                .user(UserDto.toEntity(targetDto.getUser()))
                .scores(targetDto.getScores())
                .build();
    }

    public static TargetDto fromEntity(Target target) {
        return TargetDto.builder()
                .targetNo(target.getNo())
                .user(UserDto.fromEntity(target.getUser()))
                .targetId(target.getTargetId())
                .scores(target.getScores())
                .build();
    }

    public static List<Target> toEntityList(List<TargetDto> list) {
        return list.stream()
                .map(TargetDto::toEntity)
                .collect(Collectors.toList());
    }
}
