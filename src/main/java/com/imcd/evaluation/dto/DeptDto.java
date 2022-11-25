package com.imcd.evaluation.dto;

import com.imcd.evaluation.entity.Dept;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DeptDto {

    private Long deptNo;
    private String name;

    public static DeptDto fromEntity(Dept dept) {
        return DeptDto.builder()
                .name(dept.getName())
                .build();
    }

    public static Dept toEntity(DeptDto deptDto) {
        return Dept.builder()
                .name(deptDto.getName())
                .build();
    }
}
