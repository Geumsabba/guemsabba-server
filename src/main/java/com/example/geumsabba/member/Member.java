package com.example.geumsabba.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false, unique = true)
    private String userid;
    @Column(nullable = false)
    private String userpassword;
    private int userbirth;
    private String usergender;
    private boolean userlocal; //true면 내국인 false면 외국인
    @Column(nullable = false, unique = true)
    private String useremail;
    private String userregion;


    public Member(String username, String userid, String userpassword, int userbirth, String usergender, boolean userlocal, String useremail, String userregion) {
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
