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
			statement.setInt(1, employee.getEmpId());
			statement.setString(2, employee.getEmpName());
			statement.setString(3, employee.getEmpEmail());
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private String getDate() {
		String query = "select curdate()";
		PreparedStatement statement;
		String date = null;
		try {
			statement = JDBCConnection.getConnection().prepareStatement(query);
			ResultSet res = statement.executeQuery();
			while(res.next()) { date = res.getString(1); }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return date;
		
	}

	private String getTime() {
		String query = "select curtime()";
		PreparedStatement statement;
		String time = null;
		try {
			statement = JDBCConnection.getConnection().prepareStatement(query);
			ResultSet res = statement.executeQuery();
			while(res.next()) { time = res.getString(1); }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return time;
		
	}
	
	public int userLogin(Registration employee) {
		String query = "insert into userdata(empId, empName, date, login) values(?, ?, ?, ?)";
		String uidQuery = "select uid from userdata where login = ? ";
		
		int uid = 0;

		try {
			
			String date = getDate();
			String loginTime = getTime();
			
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setInt(1, employee.getEmpId());
			statement.setString(2, employee.getEmpName());
			statement.setString(3, date);
			statement.setString(4, loginTime);
			statement.executeUpdate();
			
			PreparedStatement statement1 = JDBCConnection.getConnection().prepareStatement(uidQuery);
			statement1.setString(1, loginTime); ;
			ResultSet res3 = statement1.executeQuery();
			while(res3.next()) { uid = res3.getInt(1); }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uid;
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
				user.setEmpId(res.getInt(1));
				user.setEmpName(res.getString(2));
				user.setEmpEmail(res.getString(3));

				list.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteRegistration(int empId) {
		String query = "delete from registration where empId = ?";

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setInt(1, empId);
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateRegistration(int empId, String empName) {
		String query = "update registration set empName = ? where empId = ?";

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, empName);
			statement.setInt(2, empId);
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean userLogout(int uid) {
		String timeQuery = "select curtime()";
		String query = "update userdata set logout = ? where uid = ?";

		try {
			
			PreparedStatement statement1 = JDBCConnection.getConnection().prepareStatement(timeQuery);
			ResultSet res1 = statement1.executeQuery();
			String logoutTime = null;
			while(res1.next()) { logoutTime = res1.getString(1); }
			
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, logoutTime);
			statement.setInt(2, uid);
			
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isValidUser(int empId, String empName) {
		String query = "select * from registration where empId = ?";
		int userCount = 0;
		String name = null;
		
		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setInt(1, empId);
			ResultSet res = statement.executeQuery();
			
			while(res.next()) {
				userCount++;
				name = res.getString(2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userCount == 1 && name.equals(empName);
	}
}
