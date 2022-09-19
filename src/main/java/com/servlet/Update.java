package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDAO;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterDAO dao = new RegisterDAO();
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");

		PrintWriter writer = response.getWriter();
		if (dao.updateRegistration(empId, empName))
			writer.println("<h2 style='color:green'> <center> Employee name with Employee ID - " + empId
					+ " has been updated </center> </h2>");
		else
			writer.println("<h2> <center> Could not update the employee name </center> </h2>");
	}

}
