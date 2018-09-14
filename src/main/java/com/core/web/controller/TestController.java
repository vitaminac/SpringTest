package com.core.web.controller;

import com.core.web.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.core.web.util.RouteConstants.TEST_PATH;

@Controller
public class TestController {
    @Autowired
    private VideoRepository repo;

    @GetMapping(TEST_PATH + "/{id}")
    @ResponseBody
    public Object test(@PathVariable Integer id) {
        return this.repo.findById(id);
    }
}
