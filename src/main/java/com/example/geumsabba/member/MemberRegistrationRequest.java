package com.example.geumsabba.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRegistrationRequest {

    private String username;
    private String email;
    private String password;

    public MemberRegistrationRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
