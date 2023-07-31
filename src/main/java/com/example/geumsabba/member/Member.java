package com.example.geumsabba.member;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Member {

    @Id
    @Column(unique = true)   //중복되게 값 저장 불가
    private String id;
    private String name; //이 3개인 db에 있는 table의 Column 요소들
    private String password;
    private String YY;
    private String MM;
    private String DD;
    private String gender;
    private String local;
    @Column(unique = true)
    private String mail;
    private String siDo; //시, 도
    private String siGunGu; //시, 군, 구
    private String dong; //동

    public Member(String id, String name, String password, String YY, String MM, String DD, String gender, String local, String mail, String siDo, String siGunGu, String dong) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.YY = YY;
        this.MM = MM;
        this.DD = DD;
        this.gender = gender;
        this.local = local;
        this.mail = mail;
        this.siDo = siDo;
        this.siGunGu = siGunGu;
        this.dong = dong;
    }
}
