package com.example.geumsabba.controller;

import com.example.geumsabba.entity.Member;
import com.example.geumsabba.entity.MemberLoginRequest;
import com.example.geumsabba.entity.MemberRegistrationRequest;
import com.example.geumsabba.entity.SessionConstants;
import com.example.geumsabba.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("geumsabba")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://geumsabba.store/"})
    @PostMapping("/signup")
    public Member registerMember(@RequestBody MemberRegistrationRequest request) {
        return memberService.registerMember(request.getUsername(), request.getUserid(),
                request.getUserpassword(), request.getUserbirth(), request.getUsergender(),
                request.isUserlocal(), request.getUseremail(), request.getUserregion());
    }

    // 로그인 요청 처리 메서드
    /*@PostMapping("/login")
    public ResponseEntity<Member> login(@RequestBody MemberLoginRequest request, HttpServletRequest request2) {
        String username = request.getUsername();
        String password = request.getPassword();

        Member member = memberService.login(username, password);

        if (member != null) {
            // 로그인 성공
            HttpSession session = request2.getSession();                         // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
            session.setAttribute(SessionConstants.LOGIN_MEMBER, member);   // 세션에 로그인 회원 정보 보관
            return ResponseEntity.ok(member);
        } else {
            // 로그인 실패
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }*/
    @CrossOrigin(origins = {"http://localhost:3000", "https://geumsabba.store/"})
    @PostMapping("/login")
    public String login(@RequestBody MemberLoginRequest request, HttpServletRequest request2, Model model) {
        String userid = request.getUserid();
        String userpassword = request.getUserpassword();

        Member member = memberService.login(userid, userpassword);

        if (member != null) {
            // 로그인 성공
            HttpSession session = request2.getSession();      // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
            session.setAttribute(SessionConstants.LOGIN_MEMBER, member);   // 세션에 로그인 회원 정보 보관
            return "redirect:/geumsabba";
        } else {
            // 로그인 실패
            model.addAttribute("message", "아이디나 비밀번호를 다시 확인해주세요.");  //메세지 띄우고
            model.addAttribute("loginUrl", "/login");  //다시 로그인 화면으로 이동처리하도록 경로 넘기기
            return "message";

        }
    }


    //로그아웃
   /* @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 세션 무효화
            session.invalidate();
            return ResponseEntity.ok("Logged out successfully.");
        } else {
            return ResponseEntity.badRequest().body("Not logged in.");
        }
    }*/
    @CrossOrigin(origins = {"http://localhost:3000", "https://geumsabba.store/"})
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 세션 무효화
            session.invalidate();
            ResponseEntity.ok("Logged out successfully.");
        } else {
            ResponseEntity.badRequest().body("Not logged in.");
        }
        return "redirect:/geumsabba";
    }


}
