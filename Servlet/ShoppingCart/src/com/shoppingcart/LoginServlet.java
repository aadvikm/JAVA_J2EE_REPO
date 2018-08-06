package com.shoppingcart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}

	private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean authentication = false;
		if(username == null || password == null){
			authentication = false;
		}
		else if(username.equalsIgnoreCase("aadvik") && password.equalsIgnoreCase("aadvik")){
			authentication = true;
		}
		else if(username.equalsIgnoreCase("muthu") && password.equalsIgnoreCase("muthu")){
			authentication = true;
		}
		else if(username.equalsIgnoreCase("brindha") && password.equalsIgnoreCase("brindha")){
			authentication = true;
		}
		else authentication = false;
		
		if(authentication){
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			req.getRequestDispatcher("/productPage").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("/loginFailPage").forward(req, resp);
		}
		
	}
	

}
