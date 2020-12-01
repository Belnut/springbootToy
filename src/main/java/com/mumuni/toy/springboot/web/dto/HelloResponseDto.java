package com.mumuni.toy.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언한 모든 필드의 getter 생성
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성해줍니다. final이 없는 경우 제외합니다.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}