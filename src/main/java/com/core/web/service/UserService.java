package com.core.web.service;

import com.core.web.error.UserNotFoundException;
import com.core.web.model.User;
import com.core.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class UserService implements UserDetailsService {
    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repo.findById(username)
                .map(u -> withUsername(u.getUsername()).password(u.getPassword()).roles("user").build())
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public User read(String username) throws UserNotFoundException {
        return this.repo.findById(username).orElseThrow(() -> new UserNotFoundException(username));
    }
}
