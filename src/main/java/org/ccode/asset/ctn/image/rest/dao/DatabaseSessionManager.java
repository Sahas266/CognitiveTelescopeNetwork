package org.ccode.asset.ctn.image.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSessionManager {
	public static Connection connection;
	private static DatabaseSessionManager instance;

	private DatabaseSessionManager() {
		connect();
	}

	public static DatabaseSessionManager getInstance() {
		if (instance == null) {
			instance = new DatabaseSessionManager();
		}
		return instance;
	}

	public static Connection getSession() {
		return connection;
	}
	
	public void connect() {
		String url = "jdbc:postgresql://localhost:5432/ctn";
		String user = "postgres";
		String password = "postgres";
		try {
			// Register the PostgreSQL driver
			Class.forName("org.postgresql.Driver");

			// Create a connection to the database
			connection = DriverManager.getConnection(url, user, password);

			if (connection != null) {
				System.out.println("Connected to the PostgreSQL database!");

			}
		} catch (ClassNotFoundException e) {
			System.out.println("PostgreSQL JDBC driver not found.");
		} catch (SQLException e) {
			System.out.println("Connection failed. Check the connection parameters.");
			e.printStackTrace();
		}
	}
}
