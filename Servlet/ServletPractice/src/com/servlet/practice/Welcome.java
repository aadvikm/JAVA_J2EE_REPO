package com.servlet.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet{
	
	public String name;
	public Welcome() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		name=config.getInitParameter("firstName") +" "+config.getInitParameter("lastName");
		System.out.println("FirstName -->:"+config.getInitParameter("firstName") +" LastName -->: "+config.getInitParameter("lastName"));
		
		ServletContext servletContext=config.getServletContext();
		name =servletContext.getInitParameter("firstName")+" "+servletContext.getInitParameter("lastName");
		System.out.println("FirstName -->: "+servletContext.getInitParameter("firstName")+" LastName -->: "+servletContext.getInitParameter("lastName"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside Welcome do get method..!!");
		resp.setContentType("Text/html");
		PrintWriter printWriter=resp.getWriter();
		printWriter.println("<html><body>");
		printWriter.println("<h2>Hi.."+ name +" !!Welcome to Servlet..!!!:)</h2>");
		printWriter.println("</body></html>");
	}
	

}
