package com.example.geumsabba.service;

import com.example.geumsabba.entity.Member;
import com.example.geumsabba.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member registerMember(String userName, String userId, String userPassword, int userBirth, String userGender, boolean userLocal, String userEmail, String userRegion) {
        Member newMember = new Member(userName, userId, userPassword, userBirth, userGender, userLocal, userEmail, userRegion);

        return memberRepository.save(newMember);
    }

    // 로그인 시도 메서드
    public Member login(String userId, String userPassword) {
        Member member = memberRepository.findByUserid(userId);
        if (member != null && userPassword.equals(member.getUserpassword())) {
            return member;
        }
        return null;
    }


}
