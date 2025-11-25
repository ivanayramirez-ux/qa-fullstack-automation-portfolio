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
		try (InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {

			if (is == null) {
				System.out.println("WARNING: config.properties NOT FOUND on classpath");
			} else {
				props.load(is);
			}

			loaded = true;

		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	public static void load(String filePath) {
		try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream(filePath)) {

			if (input == null) {
				throw new RuntimeException("Config file not found on classpath: " + filePath);
			}

			props.load(input);
			loaded = true;

		} catch (IOException e) {
			throw new RuntimeException("Failed to load properties file: " + filePath, e);
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

	  public static String getBaseUrl() {
	        String value = get("baseUrl");   // key name in config.properties
	        if (value == null || value.trim().isEmpty()) {
	            return null;
	        }
	        return value.trim();
	    }
	}

