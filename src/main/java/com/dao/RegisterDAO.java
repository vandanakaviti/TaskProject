package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Registration;
import com.connection.JDBCConnection;

public class RegisterDAO {

	public boolean insertRegistration(Registration employee) {
		String query = "insert into registration values(?, ?, ?)";

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, employee.getEmpId());
			statement.setString(2, employee.getEmpName());
			statement.setString(3, employee.getEmpEmail());
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean userLogin(Registration employee) {
		String dateQuery = "select curdate()";
		String timeQuery = "select curtime()";
		String query = "insert into userdata(empId, empName, date, login) values(?, ?, ?, ?)";

		try {
			
			PreparedStatement statement1 = JDBCConnection.getConnection().prepareStatement(dateQuery);
			ResultSet res1 = statement1.executeQuery();
			String date = null;
			while(res1.next()) { date = res1.getString(1); }
			
			PreparedStatement statement2 = JDBCConnection.getConnection().prepareStatement(timeQuery);
			ResultSet res2 = statement2.executeQuery();
			String loginTime = null;
			while(res2.next()) { loginTime = res2.getString(1); }
			
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, employee.getEmpId());
			statement.setString(2, employee.getEmpName());
			statement.setString(3, date);
			statement.setString(4, loginTime);		
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Registration> viewAllUsers() {
		List<Registration> list = new ArrayList<>();
		Registration user = null;
		String query = "select * from registration";

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				user = new Registration();
				user.setEmpId(res.getString(1));
				user.setEmpName(res.getString(2));
				user.setEmpEmail(res.getString(3));

				list.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteRegistration(String empId) {
		String query = "delete from registration where empId = ?";

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, empId);
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateRegistration(String empId, String empName) {
		String query = "update registration set empName = ? where empId = ?";

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, empName);
			statement.setString(2, empId);
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean userLogout(String uid) {
		String timeQuery = "select curtime()";
		String query = "update userdata set logout = ? where uid = ?";

		try {
			
			PreparedStatement statement1 = JDBCConnection.getConnection().prepareStatement(timeQuery);
			ResultSet res1 = statement1.executeQuery();
			String logoutTime = null;
			while(res1.next()) { logoutTime = res1.getString(1); }
			
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, logoutTime);
			statement.setString(2, uid);
			
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
