package com.core.web.error;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Class type, Object searchTerm) {
        super(String.valueOf(searchTerm) + " is not found for type " + type.getName());
    }
}
