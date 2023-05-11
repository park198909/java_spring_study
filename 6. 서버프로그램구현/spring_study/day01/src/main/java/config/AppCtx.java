package config;

import exam01.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 설정클래스로 지정 - 스프링 컨테이너에 등록됨
public class AppCtx {
    @Bean       // 객체로 지정 - 스프링 컨테이너에서 객체로 생성가능해짐
    public Hello hello() {

        return new Hello();
    }
}
