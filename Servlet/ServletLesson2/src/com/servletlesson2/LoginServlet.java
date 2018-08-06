package com.servletlesson2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class LoginServlet extends HttpServlet{

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		boolean authentication = false;
		if(userName.equalsIgnoreCase("Aadvik")){
			if(password.equals("Welcome123")){
				authentication = true;
			}
		}
		else if(userName.equalsIgnoreCase("Muthu")){
			if(password.equals("Muthu")){
				authentication = true;
			}
		}
		if(authentication){
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("successServlet");
			requestDispatcher.forward(req, resp);
			
		}
		else{
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginFailedServlet");
			requestDispatcher.forward(req, resp);
		}
	}

}
