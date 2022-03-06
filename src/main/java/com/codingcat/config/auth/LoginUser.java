package com.codingcat.config.auth;

// LoginUser 어노테이션 생성하기

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
/*
@Retention 어노테이션은 어노테이션의 라이프 사이클을 설정
RetentionPolicy.RUNTIME : 런타임시점까지 유지 (Reflection API로 어노테이션 정보 조회 가능)
 */


