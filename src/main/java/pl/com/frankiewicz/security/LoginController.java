package pl.com.frankiewicz.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    public String hello;

    @GetMapping("/hello")
    public String hello(){
        Authentication aut = SecurityContextHolder.getContext().getAuthentication();

        return "Hello world";
    }
    
}
