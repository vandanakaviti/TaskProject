package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDAO;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterDAO dao = new RegisterDAO();
		String empId = request.getParameter("empId");
		
		PrintWriter writer = response.getWriter();
		if (dao.deleteRegistration(empId)) writer.println("<font color=green> <center> <h2> Employee with Employee ID - " + empId + " has been deleted </h2> </center> </font>");
		else writer.println("<font color=red> <center> <h2> Could not delete the employee </h2> </center> </font>");
	}

}
