package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Registration;
import com.dao.RegisterDAO;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterDAO dao = new RegisterDAO();
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String empEmail = request.getParameter("empEmail");
		
		Registration employee = new Registration(empId, empName, empEmail);
		
		PrintWriter writer = response.getWriter();
		if (dao.insertRegistration(employee)) {
			writer.println("<h1 style='color:green'> <center> Registered successfully! </center> </h1>");
			RequestDispatcher req = request.getRequestDispatcher("index.jsp");
			req.include(request, response);
		}
		
		else {
			writer.println("<h1 style='color:red'> <center> Could not register! </center> </h1>");
		}
		
	}

}
