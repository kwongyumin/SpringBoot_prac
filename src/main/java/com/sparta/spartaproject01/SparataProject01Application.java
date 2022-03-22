package com.sparta.spartaproject01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;


@EnableJpaAuditing // 생성 시간/수정 시간 자동 업데이트
@SpringBootApplication
public class SparataProject01Application {
    @PostConstruct // 스프링 실행 시 제일 먼저 실행.
    public void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        //타임존을 서울 시간대로 설정
    }


    public static void main(String[] args) {
        SpringApplication.run(SparataProject01Application.class, args);




    }

}
