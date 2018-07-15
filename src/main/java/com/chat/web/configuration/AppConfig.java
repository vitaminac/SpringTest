package com.chat.web.configuration;

import com.chat.web.bean.Traductor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Traductor traductor() {
        return new Traductor("en");
    }
}
