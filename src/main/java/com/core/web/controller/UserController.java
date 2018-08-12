package com.core.web.controller;

import com.core.web.model.User;
import com.core.web.repository.UserRepository;
import com.core.web.util.Constants;
import com.core.web.util.PathMappingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.core.web.util.StaticPathConstants.CrossOriginDomain;

@RestController
@RequestMapping(value = PathMappingConstants.UserMappingPath, headers = {Constants.XMLHttpRequest})
@CrossOrigin(methods = {RequestMethod.OPTIONS, RequestMethod.POST}, origins = CrossOriginDomain)
public class UserController {
    private UserRepository repo;

    @Autowired
    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<User> register(@Valid @RequestBody final User user) {
        // TODO: prohibit create user when there is already one with same username
        final User newUser = this.repo.save(user);
        return ResponseEntity.ok().body(newUser);
    }
}
