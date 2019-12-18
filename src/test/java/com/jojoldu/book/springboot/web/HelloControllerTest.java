package com.jojoldu.book.springboot.web;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
        import org.springframework.test.context.junit4.SpringRunner;
        import org.springframework.test.web.servlet.MockMvc;

        import static org.hamcrest.Matchers.is;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)  // 1
@WebMvcTest // 2
public class HelloControllerTest {

    @Autowired //3
    private MockMvc mvc;  //4

    @Test
    public void hello_return() throws  Exception {
        String hello = "hello";
        mvc.perform(get("/hello")) //5
                .andExpect(status().isOk()) //6
                .andExpect(content().string(hello)); //7
    }

    @Test
    public void helloDto_return() throws  Exception{
        String name ="hello";
        int amount =1000;

        mvc.perform(
                get("/hello/dto")
                    .param("name",name) //API 테스트 할때 사용될 요청 파라미터를 설정 String만 허용(숫자나 날짜는 문자로 변경해야가능)
                    .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) //JSON 응답값을 필드별로 검증 할 수 있는 메서드  $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}

