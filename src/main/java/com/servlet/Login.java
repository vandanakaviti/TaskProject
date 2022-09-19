package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Registration;
import com.dao.RegisterDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		
		if (empId.equals("704775") && empName.equals("Vandana")) {
			session.setAttribute("empName", empName);
			
			RegisterDAO dao = new RegisterDAO();
			String empEmail = request.getParameter("empEmail");
			Registration employee = new Registration(empId, empName, empEmail);
			dao.userLogin(employee);
			
//			request.setAttribute("varName", variable);
//			getServletContext().getRequestDispatcher("logout.jsp").forward(request,response);
			
			RequestDispatcher req = request.getRequestDispatcher("mainPage.jsp");
			req.forward(request, response);
		}
		
		else {
			String html = "<h1 style='color:red'> <center> Invalid credentials! </center> </h1>";
			writer.println(html);
			
			RequestDispatcher req = request.getRequestDispatcher("index.jsp");
			req.include(request, response);
		}
	}

}
