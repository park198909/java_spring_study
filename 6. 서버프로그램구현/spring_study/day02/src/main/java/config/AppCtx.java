package config;

import exam05.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAspectJAutoProxy
public class AppCtx {

    @Bean
    public CachedProxy cachedProxy() {
        return new CachedProxy();
    }

    @Bean
    public ProxyCalculator proxyCalculator() {
        return new ProxyCalculator();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }


}
