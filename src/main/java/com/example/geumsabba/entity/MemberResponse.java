package com.example.geumsabba.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponse {

    private String username;
    private String userid;
    private String userpassword;
    private int userbirth;
    private String usergender;
    private boolean userlocal;
    private String useremail;
    private String userregion;

    public MemberResponse(String username, String userid, String userpassword, int userbirth, String usergender, boolean userlocal, String useremail, String userregion) {
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
