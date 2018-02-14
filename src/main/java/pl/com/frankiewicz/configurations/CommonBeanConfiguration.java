package pl.com.frankiewicz.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanConfiguration {
//tu sie wrzuca beany
    @Bean
    public String HelloWord(){
        return "Hello World!";
    }
}
