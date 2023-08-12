package com.example.geumsabba.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "Newsletter")
public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
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
    private String image1;
    private String image2;
    private String image3;

    public Newsletter(Date date, String editor, String title, String header, String subtitle1, String subtitle2, String subtitle3, String content1, String content2, String content3, String image1, String image2, String image3) {
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
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }
}
