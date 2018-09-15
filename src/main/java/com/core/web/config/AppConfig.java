package com.core.web.config;

import com.core.web.dao.repository.ResourceRepository;
import com.core.web.dao.repository.UserRepository;
import com.core.web.model.User;
import com.core.web.service.storage.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class AppConfig {
    @Bean
    public StorageProperties buildStorageProperties() {
        return new StorageProperties() {
            private Path location = Paths.get("static/files/");

            @Override
            public Path getLocation() {
                return location;
            }
        };
    }

    @Bean
    public CommandLineRunner prepare(ResourceRepository resourceRepository, StorageProperties properties, UserRepository userRepository) {
        return args -> {
            final User user = new User();
            user.setUsername("demo");
            user.setPassword("demo123");
            userRepository.save(user);
//            repository.deleteAll();
//            Files.walk(properties.getLocation()).forEach(path -> {
//                try {
//                    if (path.toFile().isFile()) {
//                        Files.delete(path);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
        };
    }
}
