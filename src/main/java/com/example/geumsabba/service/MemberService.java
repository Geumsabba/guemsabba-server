package com.example.geumsabba.service;

import com.example.geumsabba.member.Member;
import com.example.geumsabba.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member registerMember(String username, String email, String password) {
        Member newMember = new Member(username, email, password);

        return memberRepository.save(newMember);
    }

    // 로그인 시도 메서드
    public Member login(String username, String password) {
        Member member = memberRepository.findByUsername(username);
        if (member != null && password.equals(member.getPassword())) {
            return member;
        }
        return null;
    }

}
