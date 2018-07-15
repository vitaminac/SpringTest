package com.chat.web.configuration;

public class PathMappingConstants {
    public static final String MatchesAllPath = "/{path:[^\\.]+}/**";
    public static final String ForwardToRootPath = "forward:/";
    public static final String UserMappingPath = "/users";
    public static final String LanguageMappingPath = "/languages/{language}";
}
