package com.chat.web.utils;

import java.util.HashMap;
import java.util.Map;

public class MultiLanguageSupport {
    public interface Language {
        String getLanguageName();

        String getWelcome();
    }

    private static final Language defaultLanguage = new Language() {
        @Override
        public String getLanguageName() {
            return "English";
        }

        @Override
        public String getWelcome() {
            return "Hello World";
        }
    };
    private static final Map<String, Language> languages = new HashMap<>();

    static {
        languages.put("en", defaultLanguage);
        languages.put("es", new Language() {
            @Override
            public String getLanguageName() {
                return "Español";
            }

            @Override
            public String getWelcome() {
                return "Hola Mundo";
            }
        });
    }

    public static Language getLanguage(String lan) {
        final Language language = languages.get(lan);
        if (language == null) {
            return defaultLanguage;
        } else {
            return language;
        }
    }
}
