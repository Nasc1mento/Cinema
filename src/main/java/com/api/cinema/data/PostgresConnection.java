package com.api.cinema.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.api.cinema.util.ConfigLoader;

public class PostgresConnection implements IConnection {

	private final static String DB_ADDRESS;
	private final static String DB_PORT;
	private final static String DB_SCHEMA;
	private final static String DB_USER;
	private final static String DB_PASSWORD;
	private final static String DB_URL;
	private Connection connection;

	static {
		Properties properties = ConfigLoader.loadConfig();
		DB_ADDRESS = properties.getProperty("DB_ADDRESS");
		DB_PORT = properties.getProperty("DB_PORT");
		DB_SCHEMA = properties.getProperty("DB_SCHEMA");
		DB_USER = properties.getProperty("DB_USER");
		DB_PASSWORD = properties.getProperty("DB_PASSWORD");
		DB_URL = String.format("jdbc:postgresql://%s:%s/%s", DB_ADDRESS, DB_PORT, DB_SCHEMA);
	}

	@Override
	public Connection getConnection() {

		if (connection == null) {
			
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				return connection;

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return connection;
	}
}
