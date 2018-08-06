package com.servlet.lesson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodBye extends HttpServlet{
	
	private String name = ""; 

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext  = config.getServletContext();
		System.out.println("servletContext.getInitParameter(firstName) --> "+servletContext.getInitParameter("firstName"));
		System.out.println("servletContext.getInitParameter(lastName) --> "+servletContext.getInitParameter("lastName"));
		name = servletContext.getInitParameter("firstName")+" "+servletContext.getInitParameter("lastName");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside GoodBye doGet...");
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<html><body>");
		printWriter.println("<h3> Good Bye "+name+"!!! See you soon!!!</h3>");
		printWriter.println("</body></html>");
	}

	public GoodBye() {
		super();
		// TODO Auto-generated constructor stub
	}

}
