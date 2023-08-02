package com.example.geumsabba.controller;

import com.example.geumsabba.member.Member;
import com.example.geumsabba.member.MemberLoginRequest;
import com.example.geumsabba.member.MemberRegistrationRequest;
import com.example.geumsabba.repository.MemberRepository;
import com.example.geumsabba.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("guemsabba")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public Member registerMember(@RequestBody MemberRegistrationRequest request) {
        return memberService.registerMember(request.getUsername(), request.getEmail(), request.getPassword());
    }

    // 로그인 요청 처리 메서드
    @PostMapping("/login")
    public ResponseEntity<Member> login(@RequestBody MemberLoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        Member member = memberService.login(username, password);

        if (member != null) {
            // 로그인 성공
            return ResponseEntity.ok(member);
        } else {
            // 로그인 실패
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
