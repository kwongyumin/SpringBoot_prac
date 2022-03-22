package com.sparta.spartaproject01.domain;

import lombok.Getter;



//컨트롤러에서 직접 테이블에 값을 전달하지 않고
// DTO 객체를 통해서 데이터를 주고받음
@Getter
public class BoardRequestDto {

    private String username;
    private String contents;
    private String title;


}
