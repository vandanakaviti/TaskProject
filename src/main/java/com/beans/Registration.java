package com.beans;

public class Registration {
	private String empId;
	private String empName;
	private String empEmail;
	
	public Registration() {
		super();
	}

	public Registration(String empId, String empName, String empEmail) {
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
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
