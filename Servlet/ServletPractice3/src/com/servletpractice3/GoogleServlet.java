package com.servletpractice3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoogleServlet extends HttpServlet {

	public GoogleServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Redirecting to google...");
		resp.sendRedirect("https://www.google.com/search?q="+req.getParameter("search"));
	}
	
	

}
