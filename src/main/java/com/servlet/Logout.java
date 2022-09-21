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

import com.dao.RegisterDAO;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);   
		int uid = (int) session.getAttribute("uid");
		RegisterDAO dao = new RegisterDAO();
		
		if (dao.userLogout(uid)) {
			RequestDispatcher req = request.getRequestDispatcher("logout.jsp");
			req.forward(request, response);
		}
		
		else {
			PrintWriter writer = response.getWriter();
			writer.println("<head>");
			writer.println("<title> Error logging out! </title>");
			writer.println("<body>");
			writer.println("<font color=red>");
			writer.println("<center>");
			
			writer.println("<h2> Error while logging out. </h2>");
			writer.println("<h2> Please retry ");
			writer.println("<font color=red> <a href = 'mainPage.jsp'> &#8635 </a> </h2> </font>");

			writer.println("</center>");
			writer.println("</font>");
			writer.println("</body>");
			writer.println("</head>");
		}
		
	}

}
