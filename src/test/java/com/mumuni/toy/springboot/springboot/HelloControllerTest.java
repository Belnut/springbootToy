package com.mumuni.toy.springboot.springboot;

import com.mumuni.toy.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)    //springRunner 스프링 실행자 실행 (not junit, junit과 spring boot test 연결다리)
@WebMvcTest(controllers = HelloController.class) //Web(Spring mvc)만 집중하는 어노테이션
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; // http -get -post api 테스트용

    @Test
    public void return_hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // '/hello' 주소로 http get 요청, 체이닝 지원
                .andExpect(status().isOk()) // mvc.perform 결과 검증 : http header의 status 검증, 200인지 검사 (200, 404, 500)
                .andExpect(content().string(hello)); // mvc.perform 결과 검증 : 응답 본문의 내용 검증
    }

    @Test
    public void return_helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)                        //요청 파라매터 : only String
                .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))        //필드별로 json 응답값을 검증할 수 있음, $ 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
