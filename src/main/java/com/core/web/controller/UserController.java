package com.core.web.controller;

import com.core.web.model.User;
import com.core.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

import static com.core.web.util.HttpConstants.XML_HTTP_REQUEST;
import static com.core.web.util.PathMappingConstants.LoginMappingPath;
import static com.core.web.util.PathMappingConstants.LogoutMappingPath;
import static com.core.web.util.PathMappingConstants.RegisterMappingPath;

@RestController
@RequestMapping(headers = {XML_HTTP_REQUEST})
public class UserController {
    private UserRepository repo;

    @Autowired
    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // TODO: @ApiController register
    @PostMapping(RegisterMappingPath)
    public ResponseEntity<User> register(@Valid @RequestBody final User user) {
        // TODO: prohibit create user when there is already one with same username
        final User newUser = this.repo.save(user);
        return ResponseEntity.ok().body(newUser);
    }

    @GetMapping(LoginMappingPath)
    public Principal login(Principal principal) {
        return principal;
    }

    @GetMapping(LogoutMappingPath)
    public void logout(Principal principal) {

    }
}
