package exam01;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        // 스프링 컨테이너 클래스 생성 - 설정클래스명.class를 매개변수로 주어야 한다.
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Hello hello = ctx.getBean("hello", Hello.class);    // 스프링 컨테이너 안에 Hello객체(싱글톤) 생성
        hello.message();

        Hello hello2 = ctx.getBean("hello", Hello.class);
        hello2.message();

        System.out.println(hello == hello2);

        ctx.close();
    }
}
