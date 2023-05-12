package exam01.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {
    public void send(String message) {
        System.out.println(message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertySet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy()");
    }
}
