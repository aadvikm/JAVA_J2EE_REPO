package com.servlet.lesson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet{

	public String name="";
	public HelloWorld() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext  = config.getServletContext();
		System.out.println("servletContext.getInitParameter(firstName) --> "+servletContext.getInitParameter("firstName"));
		System.out.println("servletContext.getInitParameter(lastName) --> "+servletContext.getInitParameter("lastName"));
		name = servletContext.getInitParameter("firstName")+" "+servletContext.getInitParameter("lastName");
		System.out.println("config.getInitParameter(firstName) --> "+config.getInitParameter("firstName"));
		System.out.println("config.getInitParameter(lastName) --> "+config.getInitParameter("lastName"));
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<html><body>");
		printWriter.println("<h3> Hellow World "+name+"! Welcome to Server Learning!!!</h3>");
		printWriter.println("</body></html>");
	}

}
