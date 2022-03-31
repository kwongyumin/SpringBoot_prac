package com.sparta.spartaproject01.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.spartaproject01.dto.SignupRequestDto;
import com.sparta.spartaproject01.model.User;
import com.sparta.spartaproject01.repository.UserRepository;
import com.sparta.spartaproject01.service.KakaoUserService;
import com.sparta.spartaproject01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class UserController {

    private final UserService userService;
    private final KakaoUserService kakaoUserService;
    private final UserRepository userRepository;


    @Autowired
    public UserController(UserService userService,UserRepository userRepository,KakaoUserService kakaoUserService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.kakaoUserService = kakaoUserService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup(Model model) {
        model.addAttribute("requestDto", new SignupRequestDto());
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@ModelAttribute(name = "requestDto") @Valid SignupRequestDto requestDto, BindingResult result) {

        //registerUser에서 유효성 검사,
        return userService.registerUser(requestDto,result);

    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);
        return "redirect:/board";

    }


}