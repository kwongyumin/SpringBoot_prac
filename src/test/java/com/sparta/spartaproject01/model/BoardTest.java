package com.sparta.spartaproject01.model;

import com.sparta.spartaproject01.dto.BoardRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    @DisplayName("정상 케이스")
    void createBoard(){

        //given
        String title = "테스트 케이스";
        String username = "유저네임";
        String contents = "테스트 케이스 내용";

        BoardRequestDto boardRequestDto;
        boardRequestDto = new BoardRequestDto(

                username,
                contents,
                title
        );

        //when
        Board board = new Board(boardRequestDto);

        //then
        assertNull(board.getId());
        assertEquals(title,board.getTitle());
        assertEquals(contents,board.getContents());
        assertEquals(username,board.getUsername());







    }

}