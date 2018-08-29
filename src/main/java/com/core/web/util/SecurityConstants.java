package com.core.web.util;

import static com.core.web.util.PathMappingConstants.API_ENDPOINT;
import static com.core.web.util.PathMappingConstants.LOGIN_ENDPOINT;
import static com.core.web.util.PathMappingConstants.REGISTER_ENDPOINT;

public class SecurityConstants {
    public static final String CROSS_ORIGIN_DOMAIN = "http://localhost:4200";
    public static final String FILTER_SERVICE_API = API_ENDPOINT + "/**";
    public static final String FILTER_LOGIN_API = API_ENDPOINT + LOGIN_ENDPOINT;
    public static final String FILTER_REGISTER_API = API_ENDPOINT + REGISTER_ENDPOINT;
}
