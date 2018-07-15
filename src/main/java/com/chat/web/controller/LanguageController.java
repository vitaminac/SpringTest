package com.chat.web.controller;

import com.chat.web.bean.Traductor;
import com.chat.web.model.language.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
    private final Traductor traductor;

    @Autowired
    public LanguageController(Traductor traductor) {
        this.traductor = traductor;
    }

    @GetMapping(value = "/", headers = {"X-Requested-With=XMLHttpRequest"})
    @ResponseBody
    public Language getLanguage(@RequestParam(value = "language", defaultValue = "en") String language) {
        return traductor.translate(language);
    }
}
