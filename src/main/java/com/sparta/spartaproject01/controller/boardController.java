package com.sparta.spartaproject01.controller;



import com.sparta.spartaproject01.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class boardController {


    // @AuthenticationPrincipal UserDetailsImpl userDetails
    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping("/board/write")
    public String Write(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model){


        model.addAttribute("username",userDetails.getUsername());
        return "boardWrite";
    }






}
