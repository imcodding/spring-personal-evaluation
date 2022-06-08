package com.imcd.evaluation.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    NO_USER("등록되지 않은 사용자입니다."),

    //JWT
    INVALID_JWT_SIGNATURE("유효하지 않은 토큰입니다."),
    MALFORMED_JWT_TOKEN("조작된 토큰입니다."),
    EXPIRED_JWT_TOKEN("만료된 토큰입니다."),
    UNSUPPORTED_JWT_TOKEN("지원하지 않는 토큰입니다."),
    INVALID_JWT_COMPACT("토큰 생성이 잘못되었습니다."),
    NO_ACCESS_ROLE("접근 권한이 없습니다.")
    ;
    private final String description;
}
