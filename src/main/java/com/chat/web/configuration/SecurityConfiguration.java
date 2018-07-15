package com.chat.web.configuration;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.chat.web.configuration.PathMappingConstants.FaviconIconMappingPath;
import static com.chat.web.configuration.PathMappingConstants.FilterAllJavaScript;
import static com.chat.web.configuration.PathMappingConstants.FilterAllStyleSheet;
import static com.chat.web.configuration.PathMappingConstants.FilterLanguagesMappingPath;
import static com.chat.web.configuration.PathMappingConstants.IndexMappingPath;
import static com.chat.web.configuration.PathMappingConstants.LoginMappingPath;
import static com.chat.web.configuration.PathMappingConstants.RootMappingPath;

@Configuration
@Order(SecurityProperties.IGNORED_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requiresChannel().anyRequest().requiresSecure();
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, RootMappingPath, IndexMappingPath, FilterAllJavaScript, FilterAllStyleSheet, FaviconIconMappingPath, FilterLanguagesMappingPath)
                .permitAll();
        http.authorizeRequests().antMatchers(LoginMappingPath).permitAll();
        http.authorizeRequests().anyRequest().authenticated();
    }
}
