package com.jojoldu.book.springboot;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication   //스프링 부트의 자동 설정, 스트링 Bean읽기와 생성 모두 자동성정이됨 -
// 이 위치부터 설정을 읽기떄문에 프로젝트 최상단에 위치해야한다.
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
