package com.sparta.spartaproject01.model;


import com.sparta.spartaproject01.dto.BoardRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name="board")
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자 생성
@Getter // 겟터  (lombok)
@Setter // 셋터
@Entity // 엔티티 객체 -> 테이블과 연계된 객체임을 알려준다.
public class Board extends Timestamped {

    @Id //primarykey
    @GeneratedValue(strategy = GenerationType.AUTO) // autoNumbering
    @Column(name ="board_Id")
    private Long id;

    @Column(nullable = false) // NotNull
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    //외래키 사용
    //다대일 관계
    //여러명의 유저와 게시글 하나.
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    // 게시글 삭제 시 댓글 또한 삭제되야하기 때문에 cascade remove 속성 추가
    @OneToMany(mappedBy = "board" ,fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Comment> comments;


    //userID 현재 NULL 값임. 해결해야한다.

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
