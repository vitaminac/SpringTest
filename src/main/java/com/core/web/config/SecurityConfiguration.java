package com.core.web.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.core.web.util.PathMappingConstants.LogoutMappingPath;

@Configuration
@Order(SecurityProperties.IGNORED_ORDER)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requiresChannel().anyRequest().requiresSecure();
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

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
