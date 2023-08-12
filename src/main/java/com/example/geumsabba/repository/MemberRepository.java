package com.example.geumsabba.repository;

import com.example.geumsabba.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    //Member findByUsername(String username);

    Member findByUserid(String userId);

}