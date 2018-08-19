package com.core.web.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static com.core.web.util.PathMappingConstants.API_BASE_PATH;
import static com.core.web.util.PathMappingConstants.LoginMappingPath;
import static com.core.web.util.PathMappingConstants.UserMappingPath;
import static com.core.web.util.SecurityPathFilters.FilterAllJavaScript;
import static com.core.web.util.SecurityPathFilters.FilterAllStyleSheet;
import static com.core.web.util.SecurityPathFilters.FilterLanguagesMappingPath;
import static com.core.web.util.StaticPathConstants.FaviconIconMappingPath;
import static com.core.web.util.StaticPathConstants.IndexMappingPath;
import static com.core.web.util.StaticPathConstants.RootMappingPath;

@Configuration
@Order(SecurityProperties.IGNORED_ORDER)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requiresChannel().anyRequest().requiresSecure();
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, IndexMappingPath, FilterAllJavaScript,
                        FilterAllStyleSheet, FaviconIconMappingPath, FilterLanguagesMappingPath)
                .permitAll();
        http.authorizeRequests().mvcMatchers(HttpMethod.GET, RootMappingPath, API_BASE_PATH, LoginMappingPath, API_BASE_PATH + UserMappingPath).permitAll();
        http.authorizeRequests().mvcMatchers(HttpMethod.POST, API_BASE_PATH + UserMappingPath).permitAll();

        http.authorizeRequests().anyRequest().authenticated();

        // TODO: fix this security hole
        http.csrf().ignoringAntMatchers(API_BASE_PATH + UserMappingPath);
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
