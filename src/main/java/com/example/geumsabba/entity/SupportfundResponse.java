package com.example.geumsabba.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupportfundResponse {

    private String title;
    private String region; //지역
    private String age; //나이
    private String income; //소득
    private String deadline; //지원기간
    private String hashtag1; //해시태그1
    private String hashtag2; //해시태그2
    private String hashtag3; //해시태그3
    private String link; //연결 링크
    private byte[] image; //사진

    public SupportfundResponse(String title, String region, String age, String income, String deadline, String hashtag1, String hashtag2, String hashtag3, String link) {
        this.title = title;
        this.region = region;
        this.age = age;
        this.income = income;
        this.deadline = deadline;
        this.hashtag1 = hashtag1;
        this.hashtag2 = hashtag2;
        this.hashtag3 = hashtag3;
        this.link = link;
    }
}
