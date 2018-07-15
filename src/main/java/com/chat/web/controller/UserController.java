package com.chat.web.controller;

import com.chat.web.model.User;
import com.chat.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.chat.web.configuration.Constants.XMLHttpRequest;
import static com.chat.web.configuration.PathMappingConstants.UserMappingPath;

@RestController
@RequestMapping(value = UserMappingPath, headers = {XMLHttpRequest})
public class UserController {
    private UserRepository repo;

    @Autowired
    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        final User newUser = this.repo.save(user);
        return ResponseEntity.ok().body(newUser);
    }
}
