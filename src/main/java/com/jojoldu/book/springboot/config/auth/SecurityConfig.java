package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활성화 시켜줍니다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 옵션들을 disable 합니다.
                .and()
                    .authorizeRequests()//URL별 권한 관리를 설정하는 옵션의 시작점 ,authorizeRequests가 선언되어야만 antMatchers 옵션 사용가능
                    .antMatchers("/","/css/**","/images/**",  //권한 관리 대상을 지정하는 옵션 ,URL ,HTTP 메소드 별로 관리 가능
                            // "/"등 지정된 URL들은 permitAll() 옵션을 통해 전체 열람 권한을 주었습니다.
                            "/js/**","/h2-console/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated() // anyRequest() 나머지 URL .authenticated()인증된 사용자에게만 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/")  //로그아웃 성공시 / 주소로 이동합니다.
                .and()
                    .oauth2Login() //OAuth2 로그인 기능에 대한 여러 설정의 진입점입니다.
                        .userInfoEndpoint() //OAuth2 로그인 성공 이후 사용자 정보를 사져올 때의 설정들을 담당합니다.
                            .userService(customOAuth2UserService); //소셜 로그인 성공시 후속 조치를 진행할 UserService 인터페이스의 구현체
                                                    //를 등록, 리소스 서버 에서사용자 정보를 가져온ㅅ상태에서 추가로 진행하고자 하는 기능을 명시
    }

}
