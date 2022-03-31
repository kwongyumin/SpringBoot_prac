package com.sparta.spartaproject01.service;


import com.sparta.spartaproject01.dto.BoardRequestDto;
import com.sparta.spartaproject01.dto.CommentDto;
import com.sparta.spartaproject01.model.Board;
import com.sparta.spartaproject01.model.Comment;
import com.sparta.spartaproject01.model.User;
import com.sparta.spartaproject01.repository.BoardRepository;
import com.sparta.spartaproject01.repository.CommentRepository;
import com.sparta.spartaproject01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommentService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(BoardRepository boardRepository, UserRepository userRepository, CommentRepository commentRepository){
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;


    }
    public Comment commentWrite(CommentDto commentDto,String username, Long boardId){
         //작성자
         Optional<User> findUser = userRepository.findByUsername(username);
         //게시판 아이디
         Optional<Board> findBoard = boardRepository.findById(boardId);

         Comment comment = new Comment();
         comment.setContent(commentDto.getContents());
         comment.setUsername(commentDto.getUsername());
         comment.setUser(findUser.get());
         comment.setBoard(findBoard.get());

         return commentRepository.save(comment);


    }

    @Transactional
    public Long update(Long id, CommentDto commentDto){

        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다!")

        );
        comment.update(commentDto);
        return comment.getId();
    }

    @Transactional
    public void delete(Long id){

        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다!")
        );
        commentRepository.delete(comment);
    }








}
