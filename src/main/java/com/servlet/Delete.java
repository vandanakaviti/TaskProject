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
		int empId = Integer.valueOf(request.getParameter("empId"));
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link type='text/css' rel='stylesheet' href='css/style.css'>");
		out.println("</head>");
		out.println("<body>");
		
		if (dao.deleteRegistration(empId)) out.println("<font color=green> <center> <h2> Employee with Employee ID - " + empId + " has been deleted </h2> </center> </font>");
		else out.println("<font color=red> <center> <h2> Could not delete the employee </h2> </center> </font>");
		
		out.println("<font color=dodgerblue> <center> <h2> <a href = 'mainPage.jsp'> Click here for Main page </a>  </h2> </center> </font> ");
		out.println("</body>");
		out.println("</html>");
	}

}
