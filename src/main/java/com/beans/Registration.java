package com.beans;

public class Registration {
	private int empId;
	private String empName;
	private String empEmail;
	
	public Registration() {
		super();
	}

	public Registration(int empId2, String empName, String empEmail) {
		this.empId = empId2;
		this.empName = empName;
		this.empEmail = empEmail;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	@Override
	public String toString() {
		return "Registration [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + "]";
	}
	
}
