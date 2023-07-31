package com.example.geumsabba.repository;

import com.example.geumsabba.member.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(String id);
    List<Member> findAll();
}
