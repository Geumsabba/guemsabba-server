package com.example.geumsabba.controller;

import com.example.geumsabba.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/geumsabba") //localhost:8080/geumsabba
    public String geumsabbaMain(){

        return "geumsabba";
    }

    @PostMapping("/geumsabba/signup")
    public String geumsabbaSignUp(){

        return "geumsabbasignup";
    }
}
