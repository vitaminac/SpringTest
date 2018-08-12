package com.core.web.controller;

import com.core.web.service.Traductor;
import com.core.web.model.language.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.core.web.util.Constants.XMLHttpRequest;
import static com.core.web.util.PathMappingConstants.LanguageMappingPath;

@RestController
public class LanguageController {
    private final Traductor traductor;

    @Autowired
    public LanguageController(Traductor traductor) {
        this.traductor = traductor;
    }

    @GetMapping(value = LanguageMappingPath + "/{language}", headers = {XMLHttpRequest})
    public Language getLanguage(@Valid @PathVariable final String language) {
        return traductor.translate(language);
    }
}
