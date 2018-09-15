package com.core.web.service.storage;

import com.core.web.error.storage.StorageException;
import com.core.web.error.storage.StorageFileNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
class FileSystemStorageService implements StorageService {
    private final StorageProperties storageProperties;

    public FileSystemStorageService(StorageProperties properties) {
        this.storageProperties = properties;
        this.init();
    }

    @Override
    public String store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.storageProperties.getLocation().resolve(filename), StandardCopyOption.REPLACE_EXISTING);
                return filename;
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.storageProperties.getLocation(), 1)
                    .filter(path -> !path.equals(this.storageProperties.getLocation()))
                    .map(this.storageProperties.getLocation()::relativize);
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    public Path load(String filename) {
        return this.storageProperties.getLocation().resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    public void init() {
        try {
            Files.createDirectories(this.storageProperties.getLocation());
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
