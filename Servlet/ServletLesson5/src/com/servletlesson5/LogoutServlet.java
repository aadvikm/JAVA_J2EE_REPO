package com.servletlesson5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("The length of cookie : "+req.getCookies());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginFailedServlet");
		requestDispatcher.forward(req, resp);
	}

	

}
