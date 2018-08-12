package com.core.web.model.language;

public class English implements Language {
    @Override
    public String getId() {
        return "en";
    }

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
