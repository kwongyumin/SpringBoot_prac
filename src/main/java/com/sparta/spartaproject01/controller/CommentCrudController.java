package com.sparta.spartaproject01.controller;


import com.sparta.spartaproject01.dto.CommentDto;
import com.sparta.spartaproject01.repository.CommentRepository;
import com.sparta.spartaproject01.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentCrudController {



    private final CommentService cs;

    //댓글 수정
    @PutMapping ("/comment/modify/{id}")
    public Long modify(@PathVariable Long id, @RequestBody CommentDto commentDto){


        return cs.update(id,commentDto);
    }

    //댓글 삭제
    @DeleteMapping("/comment/delete/{id}")
    public void delete(@PathVariable Long id){

        cs.delete(id);
    }
}
