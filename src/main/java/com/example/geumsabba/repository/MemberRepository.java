package com.example.geumsabba.repository;

import com.example.geumsabba.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    Member save(Member member);
    Optional<Member> findById(String id);
    List<Member> findAll();
}
