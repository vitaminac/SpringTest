package angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
public class UI {
    @Configuration
    @Order(SecurityProperties.IGNORED_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/resources/**").anyRequest();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/index.html", "/", "/home", "/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(UI.class, args);
    }

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
