package com.imcd.evaluation.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {

    ADMIN("관리자"),
    BOSS("대표"),
    EMPLOYEE("직원");

    private final String description;
}
