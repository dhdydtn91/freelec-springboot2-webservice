package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto hellodto(@RequestParam("name") String name,@RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}

//@RestController  - 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줍니다.
//                 - 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해줌.

//@GetMapping      - HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 줍니다.
//                 -RequestMapping(method = ResquestMethod.GET)으로 사용되었는데. 이제는 @GetMapping으로 가능