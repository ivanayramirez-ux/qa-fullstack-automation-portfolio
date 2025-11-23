package com.ivana.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonUtils() {
    }

    public static <T> T readFromResource(String path, Class<T> clazz) {
        try (InputStream is = JsonUtils.class.getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                throw new IllegalArgumentException("Resource not found: " + path);
            }
            return MAPPER.readValue(is, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON: " + path, e);
        }
    }
}
