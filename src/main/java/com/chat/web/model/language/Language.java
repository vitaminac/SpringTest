package com.chat.web.model.language;

import java.util.HashMap;
import java.util.Map;

public interface Language {
    static final Language defaultLanguage = English.getInstance();
    static final Map<String, Language> languages = initializeLanguages();

    static Map<String, Language> initializeLanguages() {
        Map<String, Language> languages = new HashMap<>();
        languages.put("en", English.getInstance());
        languages.put("es", Spanish.getInstance());
        return languages;
    }

    static Language getLanguage(String lan) {
        final Language language = languages.get(lan);
        if (language == null) {
            return defaultLanguage;
        } else {
            return language;
        }
    }

    String getLanguageName();

    String getLogin();

    String getRegister();

    String getWelcome();
}
