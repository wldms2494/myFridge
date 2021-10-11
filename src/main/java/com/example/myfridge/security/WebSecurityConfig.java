package com.example.myfridge.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration //스프링이 기동되는 순간에 설정되는 포인트라는 설정
@EnableWebSecurity
//WebSecurityConfigurerAdapter라는 추상클래스를 상속받음
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //패스워드 복호화불가하게 이상한 문장으로 바꾸는 것.
    // bean으로 등록하고 configuration이 되어야하기에 security에 넣었음음,
    // 암호화할수있는 알고리즘 준비완료함.
    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }



    @Override
    public void configure(WebSecurity web) {
// h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
        web
                .ignoring()
                .antMatchers("/h2-console/**");


    }



    @Override //이부분 다시 알아보기
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();



        http.authorizeRequests()
                //인증한 사람들에게 모든 서비스를 제공할 순 없다.
                //인증된 사용자가 접근하려는 자원에 대한 권한이 있는지 없는지 확인하는 절차가 필요


// image 폴더를 login 없이 허용
                .antMatchers("/images/**").permitAll()
// css 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()
// 회원 관리 처리 API 전부를 login 없이 허용
                .antMatchers("/user/**").permitAll()
// 그 외 어떤 요청이든 '인증'


                // css 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()

                //그 외 어떤 요청이든 어떤 요청이든 '인증'
                .anyRequest().authenticated()
                .and()
                // 로그인 기능
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/")//로그인 성공시 인덱스로
                .failureUrl("/user/login?error")
                .permitAll()
                .and()
                // 로그아웃 기능
                .logout()
                .permitAll();


    }
}
















