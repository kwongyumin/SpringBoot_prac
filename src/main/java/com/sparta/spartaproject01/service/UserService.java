package com.sparta.spartaproject01.service;


import com.sparta.spartaproject01.repository.*;
import com.sparta.spartaproject01.dto.SignupRequestDto;
import com.sparta.spartaproject01.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Optional;


@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    //private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";



    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    //회원등록
    public String registerUser(SignupRequestDto requestDto, BindingResult result) {
        // 회원 ID 중복 확인
        String username = requestDto.getUsername();

        Optional<User> userId = userRepository.findByUsername(requestDto.getUsername());
        if(userId.isPresent()){
            FieldError fieldError = new FieldError("requestDto","username","이미 존재하는 ID입니다");
            result.addError(fieldError);
        }
        //패스워드 체크
        if(requestDto.getPassword().equals(requestDto.getUsername())){
            FieldError fieldError = new FieldError("requestDto","password","비밀번호가 아이디와 일치합니다.");
            result.addError(fieldError);
        }

        if(!requestDto.getPassword().equals(requestDto.getCheckPw())){
            FieldError fieldError = new FieldError("requestDto","checkPw","암호가 일치하지 않습니다.");
            result.addError(fieldError);

        }
        //이메일 중복 체크
        Optional<User> userEmail = userRepository.findByEmail(requestDto.getEmail());
        if(userEmail.isPresent()){
            FieldError fieldError = new FieldError("requestDto","email","이미 존재하는 email 입니다.");
            result.addError(fieldError);
        }

        //유효성 검사에 해당하는 결과가 있다면, 다시 회원가입 페이지로 리턴,
        if(result.hasErrors()) {
            return "signup";

        }

        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
        String email = requestDto.getEmail();

        User user = new User(username, password, email);
        userRepository.save(user);
        return "redirect:/user/login";
    }


}


