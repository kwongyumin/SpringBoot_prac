package com.sparta.spartaproject01.service;

import com.sparta.spartaproject01.model.Board;
import com.sparta.spartaproject01.repository.BoardRepository;
import com.sparta.spartaproject01.dto.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository br;


    //단일객체 조회
    public Optional<Board> findOne(long idx){
        return br.findById(idx);

    }
    //업데이트
    @Transactional
    public Long update(Long id, BoardRequestDto requestDto){

        Board board = br.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다!")

        );
        board.update(requestDto);
        return board.getId();
    }

    //Transactional 테스트 ,
    //삭제
    @Transactional
    public void delete(Long id){
       br.deleteById(id);
    }


}
