package com.sparta.spartaproject01.controller;


import com.sparta.spartaproject01.domain.Board;
import com.sparta.spartaproject01.domain.BoardRepository;
import com.sparta.spartaproject01.domain.BoardRequestDto;
import com.sparta.spartaproject01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class boardCrudController {

    private final BoardRepository br;
    private final BoardService bs;

    //전체목록조회
    @GetMapping("/board")
    public ModelAndView boardList(){
        ModelAndView mav = new ModelAndView();
        List<Board> list = br.findAllByOrderByModifiedAtDesc();
        mav.addObject("list",list);
        return mav;
    }

    //작성 글들을 받아와서 저장
    @PostMapping("/board/write")
    public Board boardWrite(@RequestBody BoardRequestDto boardDto){
        Board board = new Board(boardDto);
        return br.save(board);
    }

    //특정 작성글의 index 번호를 받아와서 불러온다.
    @GetMapping("/board/{id}")
    public ModelAndView boardView(@PathVariable long id){

        Optional<Board> boardDto = bs.findOne(id);
        ModelAndView mav= new ModelAndView("view");
        mav.addObject("boardOne",boardDto.get());
        mav.addObject("index",id);
        //optional 에 저장된 값에 접근 할 수 있는 get() 메서드
        return mav;
    }

    //수정
    @GetMapping("/board/modify/{id}")
    public ModelAndView modify(@PathVariable long id){
        Optional<Board> boardDto = bs.findOne(id);
        ModelAndView mav = new ModelAndView("boardWrite");
        mav.addObject("boardOne",boardDto.get());
        mav.addObject("index",id);
        return mav;

    }
    // id 를 받아와서 수정 ,
    @PutMapping("/board/modify/{id}")
    public Long modify(@PathVariable long id,@RequestBody BoardRequestDto boardDto){

        return bs.update(id,boardDto);


    }
    // 삭제
    @DeleteMapping("/board/delete/{id}")
    public Long boardDelete(@PathVariable long id){
        bs.delete(id);
        return id;
    }





}
