package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
	
	private ServletConfig servletConfig ;
	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public void init( ServletConfig config) throws ServletException {
		this.servletConfig = config;
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<html><body>");
		printWriter.println("<h3> Welcome "+req.getParameter("userName")+"!!! </h3>");
		printWriter.println("<h3> Password you entered is "+req.getParameter("password")+"</h3>");
		printWriter.println("<h3> Below are context param : </h3>");
		ServletContext servletContext = req.getServletContext();
		Enumeration<String> enumeration = servletContext.getInitParameterNames();
		while(enumeration.hasMoreElements()){
			String paramName = enumeration.nextElement();
			printWriter.println("<h3> "+paramName +" : "+servletContext.getInitParameter(paramName)+"</h3>");	
		}
		printWriter.println("<h3> Below are config param : </h3>");
		enumeration = servletConfig.getInitParameterNames();
		while(enumeration.hasMoreElements()){
			String paramName = enumeration.nextElement();
			printWriter.println("<h3> "+paramName +" : "+servletConfig.getInitParameter(paramName)+"</h3>");	
		}
		printWriter.println("</body></html>");
	}
		
	

	
	
	

}