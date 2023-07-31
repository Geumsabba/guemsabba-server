package com.example.geumsabba.service;

import com.example.geumsabba.member.Member;
import com.example.geumsabba.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional(readOnly = true)
public class MemberService {

    private MemberRepository memberRepository;

    public String join(Member member){  //회원가입

        //같은 이름이 있는 중복 회원 X
        //validateDuplicateMember(member); //중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m-> { // null이 아니라 값이 있으면
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberId){
        return memberRepository.findById(memberId);
    }

}
