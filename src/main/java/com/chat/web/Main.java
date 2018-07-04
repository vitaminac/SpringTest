package com.chat.web;

import com.chat.web.utils.MultiLanguageSupport;
import com.chat.web.utils.MultiLanguageSupport.Language;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping(value = "/", headers = {"X-Requested-With=XMLHttpRequest"})
    public Language getLanguage(@RequestParam(value = "language", defaultValue = "en") String language) {
        return MultiLanguageSupport.getLanguage(language);
    }
}
