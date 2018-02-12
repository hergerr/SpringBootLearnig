package pl.com.frankiewicz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
   // @RestController
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
        public String helloWordParam(@RequestParam(name = "name", required = false, defaultValue = "anon") String name){
            return "Hello " + name + "!";
        }

        //przez body
        @PutMapping //to samo co do gory
        public String helloWordBody(@RequestBody String name){
            return "Hello " + name;
        }

}
