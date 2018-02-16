package pl.com.frankiewicz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                //.antMatchers("/api/**").authenticated()
                .antMatchers("/users/*").permitAll()
                .antMatchers("/*.html").permitAll()
                .anyRequest().authenticated();
        //http.httpBasic();

        http
                .formLogin()
                .loginPage("/users/login")
                .failureHandler((req, respo, e) -> respo.sendError(HttpStatus.BAD_REQUEST.value(), "Username or password inwalid"))
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/api/products").permitAll();

        http
                .logout()
                .logoutUrl("/users/logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/hello")
                .permitAll();


    }

/*
    @Autowired
    public void cofigureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin").password("pass").roles("ADMIN")
                .and()
                .withUser("user").password("pass").roles("USER");
    }
*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

}
