package com.chat.web.model.language;

public class Spanish implements Language {
    private static final Language instance = new Spanish();

    public static Language getInstance() {
        return instance;
    }

    private Spanish() {

    }

    @Override
    public String getLanguageName() {
        return "Español";
    }

    @Override
    public String getLogin() {
        return "Acceder";
    }

    @Override
    public String getRegister() {
        return "Registrar";
    }

    @Override
    public String getWelcome() {
        return "Hola Mundo";
    }
}
