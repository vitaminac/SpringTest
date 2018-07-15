package com.chat.web.bean;

import com.chat.web.model.language.English;
import com.chat.web.model.language.Language;
import com.chat.web.model.language.Spanish;

import java.util.HashMap;
import java.util.Map;

public class Traductor {
    private final Language defaultLanguage;
    private final Map<String, Language> languages;

    public Traductor(String defaultLanguage) {
        this.languages = new HashMap<>();
        this.languages.put("en", English.getInstance());
        this.languages.put("es", Spanish.getInstance());
        this.defaultLanguage = this.languages.get(defaultLanguage);
    }

    public Language translate(String lan) {
        final Language language = languages.get(lan);
        if (language == null) {
            return defaultLanguage;
        } else {
            return language;
        }
    }
}
