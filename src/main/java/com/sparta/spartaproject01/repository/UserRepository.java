package com.sparta.spartaproject01.repository;

import com.sparta.spartaproject01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User>findByKakaoId(Long kakaoId);
}