package com.core.web.util;

import static com.core.web.util.RouteConstants.FILES_API;
import static com.core.web.util.RouteConstants.LOGIN_ENDPOINT;
import static com.core.web.util.RouteConstants.REGISTER_ENDPOINT;

public class SecurityConstants {
    private SecurityConstants() {
        throw new AssertionError();
    }

    private static final String ALL_INCLUDE_CHILDREN_PATHS = "/**";
    public static final String CROSS_ORIGIN_DOMAIN = "http://localhost:4200";
    public static final String FILTER_SERVICE_API = ALL_INCLUDE_CHILDREN_PATHS;
    public static final String FILTER_LOGIN_API = LOGIN_ENDPOINT;
    public static final String FILTER_REGISTER_API = REGISTER_ENDPOINT;
    public static final String FILTER_STATIC_FILES = FILES_API + ALL_INCLUDE_CHILDREN_PATHS;
}
