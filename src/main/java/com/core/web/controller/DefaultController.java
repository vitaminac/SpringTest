package com.core.web.controller;

import com.core.web.util.PathMappingConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static com.core.web.util.PathMappingConstants.API_BASE_PATH;
import static com.core.web.util.PathMappingConstants.LoginMappingPath;
import static com.core.web.util.PathMappingConstants.LogoutMappingPath;
import static com.core.web.util.PathMappingConstants.RegisterMappingPath;
import static com.core.web.util.PathMappingConstants.UserMappingPath;
import static com.core.web.util.StaticPathConstants.MatchesAllPath;

@Controller
public class DefaultController {
    private static final Map<String, String> API_MAP;

    static {
        API_MAP = new HashMap<>();
        API_MAP.put("users", UserMappingPath);
        API_MAP.put("login", LoginMappingPath);
        API_MAP.put("logout", LogoutMappingPath);
        API_MAP.put("register", RegisterMappingPath);
    }

    /**
     * forward all requests to SPA
     */
    @GetMapping(value = MatchesAllPath)
    public String forwardSPA() {
        return PathMappingConstants.ForwardToRootPath;
    }

    @GetMapping(value = API_BASE_PATH)
    @ResponseBody
    public Map<String, String> navigation() {
        return API_MAP;
    }
}
