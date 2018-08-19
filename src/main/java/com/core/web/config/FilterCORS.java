package com.core.web.config;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.core.web.util.HttpConstants.AUTHORIZATION;
import static com.core.web.util.HttpConstants.CONTENT_TYPE;
import static com.core.web.util.HttpConstants.GET;
import static com.core.web.util.HttpConstants.OPTIONS;
import static com.core.web.util.HttpConstants.POST;
import static com.core.web.util.HttpConstants.PUT;
import static com.core.web.util.HttpConstants.X_REQUESTED_WITH;
import static com.core.web.util.StaticPathConstants.CrossOriginDomain;


@Component
public class FilterCORS implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", CrossOriginDomain);
        httpServletResponse.setHeader("Access-Control-Allow-Methods", String.join(", ", POST, GET, OPTIONS, PUT));
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", String.join(", ", X_REQUESTED_WITH, CONTENT_TYPE, AUTHORIZATION));
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
