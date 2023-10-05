package com.novProject.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드의 get메소드를 생성해줌
@RequiredArgsConstructor //초기화되지 않은 final 키워드를 사용한 필드에 생성자를 생성해줌
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
