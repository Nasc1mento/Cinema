package com.api.cinema.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	private static final String CONFIG_FILE_PATH = "config.properties";
	private static Properties properties;

	private ConfigLoader() {

	}

	public static Properties loadConfig() {
		if (properties == null) {
			properties = new Properties();

			try (FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH)) {
				properties.load(fileInputStream);
			} catch (IOException e) {
				throw new RuntimeException("Failed to load config from file: " + CONFIG_FILE_PATH, e);
			}
		}

		return properties;
	}
}
