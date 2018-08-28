package com.core.web.config;

import com.core.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.core.web.util.PathMappingConstants.LogoutMappingPath;

@Configuration
@Order(SecurityProperties.IGNORED_ORDER)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfiguration(UserService userService) {
        this.userDetailsService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.requiresChannel().anyRequest().requiresSecure();
        http.authorizeRequests().anyRequest().permitAll().and()
                .cors().disable()
//                .authorizeRequests().antMatchers(HttpMethod.GET, IndexMappingPath, FilterAllJavaScript, FilterAllStyleSheet, FaviconIconMappingPath, FilterLanguagesMappingPath).permitAll().and()
//                .authorizeRequests().mvcMatchers(HttpMethod.GET, RootMappingPath, API_BASE_PATH).permitAll().and()
//                .authorizeRequests().mvcMatchers(HttpMethod.POST, API_BASE_PATH + UserMappingPath).permitAll().and()
//                .authorizeRequests().anyRequest().authenticated().and()

                // TODO: fix this security hole
//                .csrf().ignoringAntMatchers(API_BASE_PATH + RegisterMappingPath).and()
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .csrf().disable()

                // Login
                .httpBasic().and()
                .logout().logoutUrl(LogoutMappingPath).permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        // TODO: fix password encoder
        builder.userDetailsService(this.userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        });
    }
}
