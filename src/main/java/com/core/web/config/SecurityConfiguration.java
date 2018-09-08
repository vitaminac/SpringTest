package com.core.web.config;

import com.core.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static com.core.web.util.PathMappingConstants.API_ENDPOINT;
import static com.core.web.util.PathMappingConstants.LogoutMappingPath;
import static com.core.web.util.SecurityConstants.FILTER_LOGIN_API;
import static com.core.web.util.SecurityConstants.FILTER_REGISTER_API;
import static com.core.web.util.SecurityConstants.FILTER_SERVICE_API;
import static com.core.web.util.SecurityConstants.FILTER_STATIC_FILES;

@Configuration
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
        http
                .cors().and()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().and()
                .authorizeRequests().mvcMatchers(API_ENDPOINT, FILTER_LOGIN_API, FILTER_REGISTER_API, FILTER_STATIC_FILES).permitAll().and()
                .authorizeRequests().mvcMatchers(FILTER_SERVICE_API).authenticated().and()

                // TODO: fix this security hole
//                .csrf().ignoringAntMatchers(API_ENDPOINT + REGISTER_ENDPOINT).and()
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .csrf().disable()

                // Login
                .httpBasic().and()
                .logout().logoutUrl(LogoutMappingPath).permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // this line caused our request send without cors header
        //web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
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

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        // TODO: configure
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        // configuration.setAllowCredentials(true);
        //configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
