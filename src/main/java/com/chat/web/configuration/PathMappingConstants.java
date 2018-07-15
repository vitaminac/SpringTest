package com.chat.web.configuration;

public class PathMappingConstants {
    public static final String MatchesAllPath = "/{path:[^\\.]+}/**";
    public static final String ForwardToRootPath = "forward:/";
    public static final String UserMappingPath = "/users";
    public static final String LoginMappingPath = "/login";
    public static final String LanguageMappingPath = "/languages/{language}";

    // filter from authentication
    public static final String RootMappingPath = "/";
    public static final String IndexMappingPath = "/index.html";
    public static final String FaviconIconMappingPath = "/favicon.ico";
    public static final String FilterAllJavaScript = "/*.js";
    public static final String FilterAllStyleSheet = "/*.css";
    public static final String FilterLanguagesMappingPath = "/languages/*";
}
