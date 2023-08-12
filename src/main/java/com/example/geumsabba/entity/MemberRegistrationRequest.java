package com.example.geumsabba.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class MemberRegistrationRequest {


    private String username;
    private String userid;
    private String userpassword;
    private int userbirth;
    private String usergender;
    private boolean userlocal; //true면 내국인 false면 외국인
    private String useremail;
    private String userregion;

    public MemberRegistrationRequest(String username, String userid, String userpassword, int userbirth, String usergender, boolean userlocal, String useremail, String userregion) {
        this.username = username;
        this.userid = userid;
        this.userpassword = userpassword;
        this.userbirth = userbirth;
        this.usergender = usergender;
        this.userlocal = userlocal;
        this.useremail = useremail;
        this.userregion = userregion;
    }
}