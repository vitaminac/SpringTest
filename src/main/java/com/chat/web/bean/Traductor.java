package com.chat.web.bean;

import com.chat.web.model.language.Language;

import java.util.Map;

public class Traductor {
    private final Language defaultLanguage;
    private final Map<String, Language> languages;

    public Traductor(Map<String, Language> languages, Language defaultLanguage) {
        this.languages = languages;
        this.defaultLanguage = defaultLanguage;
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
