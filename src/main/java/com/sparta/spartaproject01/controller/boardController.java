package com.sparta.spartaproject01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class boardController {

    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping("/board/write")
    public String Write(){
        return "boardWrite";
    }





}
