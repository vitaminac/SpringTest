package com.chat.web.controller;

import com.chat.web.bean.Traductor;
import com.chat.web.model.language.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.chat.web.configuration.Constants.XMLHttpRequest;
import static com.chat.web.configuration.PathMappingConstants.LanguageMappingPath;

@RestController
public class LanguageController {
    private final Traductor traductor;

    @Autowired
    public LanguageController(Traductor traductor) {
        this.traductor = traductor;
    }

    @GetMapping(value = LanguageMappingPath, headers = {XMLHttpRequest})
    public Language getLanguage(@Valid @PathVariable final String language) {
        return traductor.translate(language);
    }
}
