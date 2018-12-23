package com.core.web.util;

public class HttpConstants {
    private HttpConstants() {
    }

    // Headers
    public static final String AUTHORIZATION = "Authorization";
    public static final String X_REQUESTED_WITH = "X-Requested-With";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String XML_HTTP_REQUEST = "X-Requested-With=XMLHttpRequest";
    public static final String X_XSRF_TOKEN = "X-XSRF-TOKEN";

    // Methods
    public static final String POST = "POST";
    public static final String GET = "GET";
    public static final String OPTIONS = "OPTIONS";
    public static final String PUT = "PUT";
}
