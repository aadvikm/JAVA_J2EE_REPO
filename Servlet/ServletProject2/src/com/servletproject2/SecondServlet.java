package com.servletproject2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	public SecondServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext=getServletContext();
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body>");
		writer.write("<h2>Context params are fetched successfully!!!</h2>");
		writer.write("<h2>StudentName : "+servletContext.getAttribute("Name")+"</h2>");
		writer.write("<h2>StudentAge : "+servletContext.getAttribute("Age")+"</h2>");
		writer.write("</body></html>");
		
	}

}
