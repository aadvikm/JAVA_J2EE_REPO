package com.EmpCrudJSP;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
		boolean authentication =false;
		
		if(uname.equalsIgnoreCase("aadvik") && pwd.equalsIgnoreCase("aadvik")){
			authentication =true;
			
		}
		else if(uname.equalsIgnoreCase("brindha") && pwd.equalsIgnoreCase("brindha")){
			authentication =true;
		}
		else if(uname.equalsIgnoreCase("muthu") && pwd.equalsIgnoreCase("muthu")){
			authentication =true;
		}
		
		if(authentication){
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
