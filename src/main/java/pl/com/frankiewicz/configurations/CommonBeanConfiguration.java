package pl.com.frankiewicz.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanConfiguration {

    @Bean
    public String HelloWord(){
        return "Hello World!";
    }
}
