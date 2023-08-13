package com.example.geumsabba.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NewsletterResponse {

    private Date date;
    private String editor;
    private String title;
    private String header;
    private String subtitle1;
    private String subtitle2;
    private String subtitle3;
    private String content1;
    private String content2;
    private String content3;
    private byte[] image1;
    private byte[] image2;
    private byte[] image3;

    public NewsletterResponse(Date date, String editor, String title, String header, String subtitle1, String subtitle2, String subtitle3, String content1, String content2, String content3) {
        this.date = date;
        this.editor = editor;
        this.title = title;
        this.header = header;
        this.subtitle1 = subtitle1;
        this.subtitle2 = subtitle2;
        this.subtitle3 = subtitle3;
        this.content1 = content1;
        this.content2 = content2;
        this.content3 = content3;
    }
}
