package com.jojoldu.book.springboot.springboot.domain.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"), // 권한 코드에 항상 ROLE_이 앞에 있어야함.
    USER("ROLE_USER", "일반 사용자"); // 그래서 코드별 키 값을 ROLE_GUEST, ROLE_USER 등으로 지정

    private final String key;
    private final String title;
}