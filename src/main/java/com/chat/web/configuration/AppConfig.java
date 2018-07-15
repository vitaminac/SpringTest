package com.chat.web.configuration;

import com.chat.web.bean.Traductor;
import com.chat.web.model.language.English;
import com.chat.web.model.language.Language;
import com.chat.web.model.language.Spanish;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public Traductor traductor() {
        Map<String, Language> languages = new HashMap<>();
        Language defaultLanguage = new English();
        languages.put(defaultLanguage.getId(), defaultLanguage);
        Language language = new Spanish();
        languages.put(language.getId(), language);
        return new Traductor(languages, defaultLanguage);
    }
}
