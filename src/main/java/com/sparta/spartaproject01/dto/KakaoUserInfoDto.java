package com.sparta.spartaproject01.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor // 필요한 생성자를 생성해줌,
public class KakaoUserInfoDto {

    private Long id;
    private String username;
    private String email;



}
