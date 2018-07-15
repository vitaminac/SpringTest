package com.chat.web.model.language;

public class English implements Language {
    private static final Language instance = new English();

    public static Language getInstance() {
        return instance;
    }

    private English() { }

    @Override
    public String getLanguageName() {
        return "English";
    }

    @Override
    public String getLogin() {
        return "Log in";
    }

    @Override
    public String getRegister() {
        return "Register";
    }

    @Override
    public String getWelcome() {
        return "Hello World";
    }
}
