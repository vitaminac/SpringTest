package com.chat.web;

import com.chat.web.model.language.Language;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * forward all requests to SPA
     */
    @GetMapping(value = "/{path:[^\\.]+}/**")
    public String forwardSPA() {
        return "forward:/";
    }

    @GetMapping(value = "/", headers = {"X-Requested-With=XMLHttpRequest"})
    @ResponseBody
    public Language getLanguage(@RequestParam(value = "language", defaultValue = "en") String language) {
        return Language.getLanguage(language);
    }
}
