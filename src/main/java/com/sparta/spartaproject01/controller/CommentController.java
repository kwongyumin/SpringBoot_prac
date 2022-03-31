package com.sparta.spartaproject01.controller;


import com.sparta.spartaproject01.dto.CommentDto;
import com.sparta.spartaproject01.model.Comment;
import com.sparta.spartaproject01.repository.CommentRepository;
import com.sparta.spartaproject01.security.UserDetailsImpl;
import com.sparta.spartaproject01.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@RequiredArgsConstructor
@Controller
public class CommentController {


    private final CommentService cs;
    private final CommentRepository cr;




//Commnet DB에 값을 저장
    @PostMapping("/comment/write")
    public String commentWrite(String contents, Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        String username = userDetails.getUsername(); //로그인한 유저정보

        CommentDto commentDto = new CommentDto();// 객체 생성
        commentDto.setContents(contents); // 직접 넣어서 전달 ,
        commentDto.setUsername(username);

        cs.commentWrite(commentDto,username,boardId);
        //댓글 저장 완료 후,


        return "redirect:/board/"+boardId;

    }
    //글 수정 페이지로 이동
    @GetMapping("/comment/{commentID}/board/{boardID}")
    public String commentModified(Model model, @PathVariable(value = "commentID") Long commentID, @PathVariable(value = "boardID") Long boardID, @AuthenticationPrincipal UserDetailsImpl userDetails){

        Optional<Comment> commentDto = cr.findById(commentID);
        //클릭한 commentID를 토대로 정보를 다불러오자.

        model.addAttribute("commentID",commentID);
        model.addAttribute("commentOne",commentDto.get());
        model.addAttribute("index",boardID);
        model.addAttribute("username",userDetails.getUsername());


        return "commentModify";
    }

    //링크 발생 ->  댓글 삭제하기,
//    @GetMapping("/comment/{commentID}/delete/{boardID}")
//    public String commentDelete(@PathVariable(value="commentID") Long id, @PathVariable(value = "boardID") Long boardID){
//
//        cs.delete(id);
//
//        return "redirect:/board/"+boardID;
//
//    }


}
