package com.emp.crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if(uname.equalsIgnoreCase("aadvik") && pwd.equalsIgnoreCase("aadvik")){
			HttpSession session = req.getSession();
			session.setAttribute("uname", uname);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("home");
			requestDispatcher.forward(req, resp);
		}
		else{
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginFail");
			req.setAttribute("errorMessage", "Invalid Username/Password");
			requestDispatcher.forward(req, resp);
		}
	}

	
}
