package com.novProject.web;

import com.novProject.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller임을 알림 //JSON형태의 객체 데이터 반환
public class HelloController {

    @GetMapping("/hello") //해당 주소로 요청이 오면
    public String hello() {
        return "hello"; //문자열 hello를 반환하도록 함
    }

    @GetMapping("/hello/dto") //해당 주소로 접속하면
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount); //이 API를 호출한 곳에서 넘겨준 값들이 HelloResponseDto객체에 담겨서 리턴됨
    }
}
