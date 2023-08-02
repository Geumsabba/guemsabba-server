package com.example.geumsabba.member;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginRequest {

    private String username;
    private String password;

    public MemberLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
