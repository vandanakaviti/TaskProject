package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection connection;

	public static Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soprasteria", "root", "sopra@2022");
			return connection;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
