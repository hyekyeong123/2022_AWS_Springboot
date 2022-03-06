package com.codingcat.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // fianl이 붙은 것만 생성자 만들어주기
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
