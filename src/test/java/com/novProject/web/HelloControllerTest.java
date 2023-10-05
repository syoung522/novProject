package com.novProject.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //단위 테스트 실행방법 지정 //JUnit4.x 프레임워크가 SpringRunner.class라는 확장된 클래스를 실행함 -> 테스트 시 스프링 컨테이너를 사용할 수 있게 됨
@WebMvcTest(controllers = HelloController.class) //여러 스프링 테스트 어노테이션 중 SpringMVC에 집중할 수 있도록 하는 어노테이션
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 빈을 주입받음
    private MockMvc mvc; //MockMvc 생성

    @Test //단위 테스트를 수행할 메서드를 정의
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform( //설정한 MockMvc를 실행함
                get("/hello")) //헤당 url로 get요청을 보냄
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name) //API에게 넘겨줄 파라미터
                .param("amount", String.valueOf(amount))) //API에게 넘겨줄 파라미터 //단, 값은 String만 허용되므로 숫자, 날짜 -> 문자로 변경해야 함
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name))) //JSON응답값을 필드별로 검증 //필드명은 '$'기준으로 명시
                    .andExpect(jsonPath("$.amount", is(amount)));

    }

}

