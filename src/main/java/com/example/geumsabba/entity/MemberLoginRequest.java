package com.example.geumsabba.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginRequest {

    private String userid;
    private String userpassword;

    public MemberLoginRequest(String userid, String userpassword) {
        this.userid = userid;
        this.userpassword = userpassword;
    }
}
