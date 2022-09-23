package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Registration;
import com.dao.RegisterDAO;

@WebServlet("/ViewAllUsers")
public class ViewAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterDAO dao = new RegisterDAO();
		List<Registration> list = dao.viewAllUsers();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link type='text/css' rel='stylesheet' href='css/style.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<font> <center> <h1> Users list </h1> </center> </font>");
		out.println("<table cellspacing='0' width='200px' border='3px solid black' style='margin-left:auto; margin-right:auto'>");
		out.println("<tr>");
		out.println("<th> Employee Id </th>");
		out.println("<th> Employee Name </th>");
		out.println("<th> Employee Email </th>");
		out.println("</tr>");
		for (Registration user : list) {
			out.println("<tr>");
			out.println("<td>" + user.getEmpId() + "</td>");
			out.println("<td>" + user.getEmpName() + "</td>");
			out.println("<td>" + user.getEmpEmail() + "</td>");
			out.println("<td> <a href = 'Delete?empId=" + user.getEmpId() + "'> &#10060" + "</td>");
//			Update?empId=704775&empName=vandana	
			
//			String updatedName = request.getParameter("updName");
//			out.println("<td> <a href = 'Update?empId=" + user.getEmpId() + "&empName=" + updatedName + "'> &#9998 </a> </td>");
			
//			out.println("<td> <a href = 'updateUser.jsp'> &#9998 </a> </td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("<font color=dodgerblue> <center> <h3> <a href = 'mainPage.jsp'> Click here for Main page </a>  </h3> </center> </font> ");
		out.println("</body>");
		out.println("</html>");
	}

}
