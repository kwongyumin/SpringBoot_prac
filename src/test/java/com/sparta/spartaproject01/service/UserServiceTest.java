package com.sparta.spartaproject01.service;

import com.sparta.spartaproject01.dto.SignupRequestDto;
import com.sparta.spartaproject01.model.User;
import com.sparta.spartaproject01.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {





    @Test
    void 유저등록() {

        //given
        String username = "권규민";
        String password = "122334";
        String email = "aaaa@naver.com";


        //when

        User user = new User(username,password,email);



        //then

        assertNull(user.getId());
        assertEquals(username,user.getUsername());
        assertEquals(password,user.getPassword());
        assertEquals(email,user.getEmail());


    }
}