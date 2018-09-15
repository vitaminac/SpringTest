package com.core.web.service.user;

import com.core.web.dao.repository.UserRepository;
import com.core.web.error.UserNotFoundException;
import com.core.web.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repo.findById(username)
                .map(u -> withUsername(u.getUsername()).password(u.getPassword()).roles("user").build())
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public User read(String username) {
        return this.repo.findById(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public User getCurrentUser() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return this.read(principal.getName());
    }
}
