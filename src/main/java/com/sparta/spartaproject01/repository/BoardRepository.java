package com.sparta.spartaproject01.repository;


import com.sparta.spartaproject01.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// SQL 명령어를 전달 ,
public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findAllByOrderByModifiedAtDesc();
}
