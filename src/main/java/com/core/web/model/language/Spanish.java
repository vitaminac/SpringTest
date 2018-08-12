package com.core.web.model.language;

public class Spanish implements Language {
    @Override
    public String getId() {
        return "es";
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
