package com.api.cinema.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	private static final String CONFIG_FILE_NAME;
	private final String configFilePath;
	private final Properties properties;

	static {
		CONFIG_FILE_NAME = "config.properties";
	}

	public ConfigLoader() {
		this.configFilePath = getConfigFilePath();
		this.properties = loadProperties();
	}

	public Properties getProperties() {
		return this.properties;
	}

	private Properties loadProperties() {

		Properties properties = new Properties();

		try (FileInputStream fileInputStream = new FileInputStream(configFilePath)) {
			properties.load(fileInputStream);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config from file: " + configFilePath, e);
		}

		return properties;
	}

	private String getConfigFilePath() {
		return this.getClass().getClassLoader().getResource(CONFIG_FILE_NAME).getPath();
	}
}
