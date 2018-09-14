package com.core.web.controller;

import com.core.web.util.RouteConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static com.core.web.util.RouteConstants.LOGIN_ENDPOINT;
import static com.core.web.util.RouteConstants.LogoutMappingPath;
import static com.core.web.util.RouteConstants.MatchesAllPath;
import static com.core.web.util.RouteConstants.REGISTER_ENDPOINT;
import static com.core.web.util.RouteConstants.UserMappingPath;
import static com.core.web.util.RouteConstants.VIDEO_API;

@Controller
public class DefaultController {
    private static final Map<String, String> API_MAP;

    static {
        API_MAP = new HashMap<>();
        API_MAP.put("users", UserMappingPath);
        API_MAP.put("login", LOGIN_ENDPOINT);
        API_MAP.put("logout", LogoutMappingPath);
        API_MAP.put("register", REGISTER_ENDPOINT);
        API_MAP.put("videos", VIDEO_API);
    }

    /**
     * forward all requests to SPA
     */
    @GetMapping(value = MatchesAllPath)
    public String forwardSPA() {
        return RouteConstants.ForwardToRootPath;
    }

    @GetMapping
    @ResponseBody
    public Map<String, String> navigation() {
        return API_MAP;
    }
}
