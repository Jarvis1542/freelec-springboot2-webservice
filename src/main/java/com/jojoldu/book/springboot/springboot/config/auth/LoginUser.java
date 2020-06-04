package com.jojoldu.book.springboot.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 이 어노테이션이 생성될 수 있는 위치 제공, PARAMETER로 지정 -> 메소드의 파라미터로 선언된 객체에서만 사용 가능
@Retention(RetentionPolicy.RUNTIME) // ㄴ 이외에도 클래스 선언문에 쓸 수 있는 TYPE 등이 있다.
public @interface LoginUser { // @interface 이 파일을 어노테이션 클래스로 지정
}
