package com.servletpractice2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPage extends HttpServlet {

	public LoginPage() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName =req.getParameter("userName");
		String password =req.getParameter("password");
		boolean authentication =false;
		if(userName.equalsIgnoreCase("Brindha") && password.equalsIgnoreCase("Welcome123")){
			authentication=true;
		}
		else if(userName.equalsIgnoreCase("Aadvik") && password.equalsIgnoreCase("Muthu123")){
			authentication=true;
		}
		if(authentication){
			RequestDispatcher requestDispatcher =req.getRequestDispatcher("loginSuccess");
			requestDispatcher.forward(req, resp);
		}
		else{
			RequestDispatcher requestDispatcher =req.getRequestDispatcher("loginFailure");
			requestDispatcher.forward(req, resp);
		}
	}
	
	
	

}
