package com.example.geumsabba;


import com.example.geumsabba.member.Member;
import com.example.geumsabba.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    //@Rollback(false) // 롤백을 수행하지 않도록 설정하여 실제 데이터베이스에 데이터가 저장되도록 함
    public void testRegisterMember() {
        // Given
        String username = "john_doe";
        String email = "john.doe@example.com";
        String password = "secretpassword";

        // When
        Member newMember = memberService.registerMember(username, email, password);

        // Then
        assertNotNull(newMember.getId());
        assertEquals(username, newMember.getUsername());
        assertEquals(email, newMember.getEmail());
        // 이외에도 추가적인 검증 로직을 구현할 수 있습니다.
    }

}
