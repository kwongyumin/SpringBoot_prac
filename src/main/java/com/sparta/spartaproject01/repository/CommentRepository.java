package com.sparta.spartaproject01.repository;


import com.sparta.spartaproject01.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    //우선 이거부터 해결
    List<Comment> findByBoardIdOrderByModifiedAtDesc(Long id);

    Optional<Comment> findByUsername(String username);


/*
public List<Reply> getReply(Long postId)
{ return ReplyRepository.findAllByPostidOrderByCreatedAtDesc(postId);



 */

}
