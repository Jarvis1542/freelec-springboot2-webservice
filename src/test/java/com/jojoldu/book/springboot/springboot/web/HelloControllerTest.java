package com.jojoldu.book.springboot.springboot.web;

import com.jojoldu.book.springboot.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class) // Junit이 아닌 다른 실행자 -> 스프링 부트 테스트와 JUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class) // Controller, ContrllerAdvice 선언가능(단, Service, Component, Repository 선언불가)
public class HelloControllerTest {

    @Autowired // 스프링 관리 Bean을 주입
    private MockMvc mvc; // 웹 API 테스트할 때 사용

    @Test
    public void hello() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // get방식 요청
                .andExpect(status().isOk()) // http header의 status검증 -> 200(ok), 404, 500
                .andExpect(content().string(hello)); // 본문 내용 검증

    }

    //@Test
//    public void helloDto() throws Exception{
//        String name = "hello";
//        int amount = 1000;
//
//            mvc.perform(get("/hello/dto")
//                    .param("name", name)    // param : String 값만 허용, 숫자/날짜 등록할 때도 String으로 변경
//                    .param("amount", String.valueOf(amount)))
//                    .andExpect(status().isOk())
//                    .andExpect(jsonPath("$.name", is(name))) // jsonPath : JSON 응답값을 필드별로 검증
//                    .andExpect(jsonPath("$.amount", is(amount))); // $기준으로 필드명 명시
//
//    }
}
