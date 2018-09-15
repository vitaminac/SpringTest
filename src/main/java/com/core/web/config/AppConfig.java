package com.core.web.config;

import com.core.web.dao.repository.ResourceRepository;
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
    public CommandLineRunner prepare(ResourceRepository repository, StorageProperties properties) {
        return args -> {
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
