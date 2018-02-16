package pl.com.frankiewicz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EntityScan(
    basePackageClasses = {Application.class, Jsr310JpaConverters.class}
        )
@EnableJpaRepositories
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    //typy zlozone tez przejda np. Long, Integer
    @RequestMapping(method = RequestMethod.GET, value = "/hello/{name}/{greeting}")
    public String helloWorldPath(@PathVariable String name, @PathVariable String greeting) {
        return "Hello " + name + ", " + greeting + "!";
    }

    //przez paramentr
    //niewymagany argument, domyslnie anon
    @GetMapping("/")
    public String helloWordParam(@RequestParam(name = "name", required = false, defaultValue = "anon") String name) {
        return "Hello " + name + "!";
    }

    //przez body
    @PutMapping //to samo co do gory
    public String helloWordBody(@RequestBody String name) {
        return "Hello " + name;
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greetings")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api.*"))
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("Niklas Heidloff")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
}
