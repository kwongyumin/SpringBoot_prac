package com.sparta.spartaproject01.service;

import com.sparta.spartaproject01.domain.Board;
import com.sparta.spartaproject01.domain.BoardRepository;
import com.sparta.spartaproject01.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository br;

    public Optional<Board> findOne(long idx){
        Optional<Board> boardOne= br.findById(idx);
        return boardOne;

    }
    @Transactional
    public Long update(Long id, BoardRequestDto requestDto){

        Board board = br.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다!")

        );
        board.update(requestDto);
        return board.getId();
    }

    //Transactional 테스트 ,
    @Transactional
    public void delete(Long id){
       br.deleteById(id);
    }


}
