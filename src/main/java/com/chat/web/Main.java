package com.chat.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.chat.web.configuration.PathMappingConstants.ForwardToRootPath;
import static com.chat.web.configuration.PathMappingConstants.MatchesAllPath;

@SpringBootApplication
@Controller
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * forward all requests to SPA
     */
    @GetMapping(value = MatchesAllPath)
    public String forwardSPA() {
        return ForwardToRootPath;
    }
}
