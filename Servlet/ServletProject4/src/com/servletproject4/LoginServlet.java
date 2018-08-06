package com.servletproject4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	

	public LoginServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		boolean authentication = false;
		if(userName.equalsIgnoreCase("Aadvik")){
			if(password.equals("Aadvik")){
				authentication = true;
			}
		}
		else if(userName.equalsIgnoreCase("Muthu")){
			if(password.equals("Muthu")){
				authentication = true;
			}
		}
		if(authentication){
		
			Cookie cookie = new Cookie("user",userName);
			resp.addCookie(cookie);
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("Hello "+cookie.getValue()+",");
			printWriter.write("<form method='get' action='/ServletProject4/NextServlet'>");
			printWriter.write("<h1>You're in Page 1.....</h1>");
			printWriter.write("<input type='submit' value='NextPage'/>");
			printWriter.write("</form>");
			printWriter.write("</body></html>");
		}
		else{
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginFailServlet");
			requestDispatcher.forward(req, resp);
		}
	}

}
