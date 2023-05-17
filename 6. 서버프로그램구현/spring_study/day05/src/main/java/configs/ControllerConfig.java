package configs;

import controllers.HelloController;
import controllers.members.JoinController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("controllers")   // controllers 포함 하위클래스 전부에 빈을 적용
public class ControllerConfig {
    /**
    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public JoinController joinController() {
        return new JoinController();
    }*/
}
