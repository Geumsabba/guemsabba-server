package com.example.geumsabba.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Supportfund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String region; //지역
    private String age; //나이
    private String income; //소득
    private String deadline; //지원기간
    private String hashtag1; //해시태그1
    private String hashtag2; //해시태그2
    private String hashtag3; //해시태그3
    private String link; //연결 링크
    private String image; //사진

    public Supportfund(String title, String region, String age, String income, String deadline, String hashtag1, String hashtag2, String hashtag3, String link, String image) {
        this.title = title;
        this.region = region;
        this.age = age;
        this.income = income;
        this.deadline = deadline;
        this.hashtag1 = hashtag1;
        this.hashtag2 = hashtag2;
        this.hashtag3 = hashtag3;
        this.link = link;
        this.image = image;
    }
}
