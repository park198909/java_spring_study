package org.koreait.configs;

import org.koreait.models.member.LoginFailureHandler;
import org.koreait.models.member.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 스프링 시큐리티 - 로그인 검증 구현
        http
            .formLogin(
            f->f.loginPage("/member/login") // 로그인 실행시 이동
                    .usernameParameter("userId")    // 체크할 아이디
                    .passwordParameter("userPw")    // 체크할 비밀번호
//                        .defaultSuccessUrl("/")     // 로그인 성공시 이동
                    .successHandler(new LoginSuccessHandler()) // 로그인 성공시 이동
//                        .failureUrl("/member/login") // 로그인 실패시 이동
                    .failureHandler(new LoginFailureHandler()) // 로그인 실패시 이동
            )
            .logout(
                    f->f.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))  // 로그아웃 실행시 이동
                            .logoutSuccessUrl("/member/login")  // 로그아웃 성공시 이동
            );
        
        // 페이지 접근 권한 제어 구현
        http.authorizeHttpRequests(
                f->f.requestMatchers("/mypage/**").authenticated()  // 로그인한 회원만 접근 가능
                        .requestMatchers("/admin/**").hasAuthority("ADMIN") // 관리자만 접근 가능
                        .anyRequest().permitAll()
        );

        // 에러 코드에 따른 기능 구현
        http.exceptionHandling(
          f->f.authenticationEntryPoint((req, res, e)->{
                  String URI = req.getRequestURI(); // 현재 접속 경로
                  // 관리자 페이지 접근 시 - 401 에러페이지
                  if (URI.indexOf("/admin") != -1) {
                      res.sendError(401, "NOT AUTHORIZED");
                      return;
                  }

                  // 회원 전용 페이지 접근 시 - 로그인 페이지
                  String url = req.getContextPath() + "/member/login";
                  res.sendRedirect(url);
          })
        );
        
        return http.build();
    }

    @Bean // 스프링 시큐리티 미적용 URL 패턴 구현
    public WebSecurityCustomizer webSecurityCustomizer() {
        return w->w.ignoring().requestMatchers("/css/**", "/js/**", "/images/**", "/upload/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {  // 비밀번호를 BCrypt 로 자동 인코딩
        return new BCryptPasswordEncoder();
    }

}
