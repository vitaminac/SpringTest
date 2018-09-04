package com.core.web.controller;

import com.core.web.repository.VideoRepository;
import com.core.web.util.PathMappingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static com.core.web.util.PathMappingConstants.API_ENDPOINT;
import static com.core.web.util.PathMappingConstants.LOGIN_ENDPOINT;
import static com.core.web.util.PathMappingConstants.LogoutMappingPath;
import static com.core.web.util.PathMappingConstants.MatchesAllPath;
import static com.core.web.util.PathMappingConstants.REGISTER_ENDPOINT;
import static com.core.web.util.PathMappingConstants.TEST_PATH;
import static com.core.web.util.PathMappingConstants.UserMappingPath;
import static com.core.web.util.PathMappingConstants.VIDEO_API;

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
        return PathMappingConstants.ForwardToRootPath;
    }

    @GetMapping(value = API_ENDPOINT)
    @ResponseBody
    public Map<String, String> navigation() {
        return API_MAP;
    }

    // test

    @Autowired
    private VideoRepository repo;

    @GetMapping(TEST_PATH + "/{id}")
    @ResponseBody
    public Object test(@PathVariable Integer id) {
        return this.repo.findById(id);
    }
}
