package com.core.web.util;

import static com.core.web.util.PathMappingConstants.API_ENDPOINT;
import static com.core.web.util.PathMappingConstants.FILES_API;
import static com.core.web.util.PathMappingConstants.LOGIN_ENDPOINT;
import static com.core.web.util.PathMappingConstants.REGISTER_ENDPOINT;

public class SecurityConstants {
    private static final String ALL_INCLUDE_CHILDREN_PATHS = "/**";
    public static final String CROSS_ORIGIN_DOMAIN = "http://localhost:4200";
    public static final String FILTER_SERVICE_API = API_ENDPOINT + ALL_INCLUDE_CHILDREN_PATHS;
    public static final String FILTER_LOGIN_API = API_ENDPOINT + LOGIN_ENDPOINT;
    public static final String FILTER_REGISTER_API = API_ENDPOINT + REGISTER_ENDPOINT;
    public static final String FILTER_STATIC_FILES = FILES_API + ALL_INCLUDE_CHILDREN_PATHS;
}
