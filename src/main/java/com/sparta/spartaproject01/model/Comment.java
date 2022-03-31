package com.sparta.spartaproject01.model;


import com.sparta.spartaproject01.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Setter
@Getter
@Entity(name ="comment")
public class Comment extends Timestamped{
    //댓글 시퀀스
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="comment_id")
    private Long id;

    //댓글 내용

    @Column(nullable = false)
    private String username;

    @Column(nullable = false,length = 120)
    private String content;

    //댓글 포함된 게시글
    @ManyToOne
    @JoinColumn(name="board_Id")
    private Board board;

    //댓글 쓴 유저
    @ManyToOne
    @JoinColumn(name="user_Id")
    private User user;


    public Comment(CommentDto commentDto){
        this.username = commentDto.getUsername();
        this.content = commentDto.getContents();
    }

    public Long update(CommentDto commentDto){
        long result =1;
        this.content = commentDto.getContents();
        this.username = commentDto.getUsername();

        return result;
    }

}
