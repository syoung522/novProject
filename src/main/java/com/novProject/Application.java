package com.novProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링 부트 자동 설정, 스프링 Bean 읽기, 생성 모두 자동 설정됨. 이곳부터 설정을 읽어가므로 항상 클래스 최상에 있어야 하는 클래스
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); //내장WAS(Web Application Server)를 실행함
    }
}