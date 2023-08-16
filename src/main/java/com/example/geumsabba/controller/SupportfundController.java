package com.example.geumsabba.controller;

import com.example.geumsabba.entity.Supportfund;
import com.example.geumsabba.entity.SupportfundResponse;
import com.example.geumsabba.service.SupportfundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("geumsabba")
public class SupportfundController {

    @Autowired
    private SupportfundService supportfundService;

    public SupportfundController(SupportfundService supportfundService) {
        this.supportfundService = supportfundService;
    }
    
    @CrossOrigin(origins = {"http://localhost:3000", "https://geumsabba.store/"})
    @GetMapping("/supportfund/getall")  // 지원금 전부 불러오기
    public ResponseEntity<List<SupportfundResponse>> newsletterGetAll() {
        List<Supportfund> supportfunds = supportfundService.getAllSupportfund();

        List<SupportfundResponse> responseList = supportfunds.stream()
                .map(supportfund -> {

                    String Dday = " ";
                    String deadlineStr = supportfund.getDeadline();

                    //상시 신청인 경우 D-365로 표시
                    if(deadlineStr.equals("상시")){
                        Dday = "D-365";
                    }else{
                        try{
                            //문자열을 날짜로 변환
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");//.withResolverStyle(ResolverStyle.STRICT);
                            LocalDate deadlineDate = LocalDate.parse(deadlineStr, formatter);

                            //D-day 계산
                            LocalDate currentDate = LocalDate.now();
                            long daysUntilDday = ChronoUnit.DAYS.between(currentDate, deadlineDate);

                            //다시 문자열로 변환
                            String num = String.valueOf(daysUntilDday);
                            if(daysUntilDday<0){
                                Dday = "마감";
                            }else{
                                Dday = "D-"+num;
                            }
                        }catch (DateTimeParseException e) {
                        }

                    }
                    SupportfundResponse response = new SupportfundResponse(
                            supportfund.getTitle(), supportfund.getRegion(), supportfund.getAge(),
                            supportfund.getIncome(),Dday, supportfund.getHashtag1(),
                            supportfund.getHashtag2(), supportfund.getHashtag3(), supportfund.getLink());

                    try {
                        Resource resource = new ClassPathResource(supportfund.getImage());
                        InputStream inputStream = resource.getInputStream();
                        byte[] imageBytes = inputStream.readAllBytes();

                        response.setImage(imageBytes);
                    } catch (IOException e) {
                        // Handle the exception
                    }

                    return response;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }

}
