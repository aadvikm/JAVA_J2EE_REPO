package com.deptcrudservlethibernate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =req.getParameter("username");
		String password =req.getParameter("password");
		boolean authentication =false;
		
		if(username.equalsIgnoreCase("Brindha") && password.equalsIgnoreCase("Brindha")){
			authentication=true;
		}
		else if(username.equalsIgnoreCase("Aadvik") && password.equalsIgnoreCase("Aadvik")){
			authentication=true;
		}
		else if(username.equalsIgnoreCase("Muthu") && password.equalsIgnoreCase("Muthu")){
			authentication=true;
		}	
		if(authentication){
			HttpSession session=req.getSession();
			session.setAttribute("username", username);
			RequestDispatcher reDes=req.getRequestDispatcher("home");
			reDes.forward(req, resp);
		}
		else{
			RequestDispatcher reDes=req.getRequestDispatcher("loginFail");
			reDes.forward(req, resp);
		}
	}

}
