package com.sparta.spartaproject01.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@NoArgsConstructor // 기본 생성자 생성
@Getter // 겟터  (lombok)
@Setter // 셋터
@Entity // 엔티티 객체 -> 테이블과 연계된 객체임을 알려준다.
public class Board extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO) // autoNumbering
    @Id //primarykey
    private Long id;

    @Column(nullable = false) // NotNull
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;



    public Board(BoardRequestDto requestDto){

        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();


    }
    public Long update(BoardRequestDto requestDto){
        long result = 1;

        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();

        return result;
    }


}
