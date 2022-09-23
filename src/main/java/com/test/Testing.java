package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.JDBCConnection;
import com.dao.RegisterDAO;

public class Testing {
	public boolean isConnected() throws SQLException {
		Connection con = JDBCConnection.getConnection();
		return con != null;
		
	}
	
	public int isUser() {
		
		RegisterDAO dao = new RegisterDAO();
		int empId = 704775;
		String empName = "Vandana";
		
//		int empId = 123456;
//		String empName = "Varsha";
		
		boolean isValidUser = dao.isValidUser(empId, empName);
		if (isValidUser) return 1;
		return 0;
		
	}
}
