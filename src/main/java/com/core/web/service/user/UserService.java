package com.core.web.service.user;

import com.core.web.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User read(String username);

    User getCurrentUser();
}
