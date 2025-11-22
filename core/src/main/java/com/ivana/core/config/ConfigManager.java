package com.ivana.core.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties props = new Properties();
    private static boolean loaded = false;

    public static void load() {
        if (loaded) {
            return;
        }
        try (InputStream is = ConfigManager.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (is == null) {
                throw new RuntimeException("config.properties not found on classpath");
            }
            props.load(is);
            loaded = true;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        if (!loaded) {
            load();
        }
        return props.getProperty(key);
    }

    public static int getInt(String key, int defaultValue) {
        String value = get(key);
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        return Integer.parseInt(value.trim());
    }
}
