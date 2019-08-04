package spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring.aop.aspect.Audience;

/**
 * 配置类
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConsertConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }
}
