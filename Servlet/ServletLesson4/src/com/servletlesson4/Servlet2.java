package com.servletlesson4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		System.out.println("servletContext.getAttribute(empName) --> "+servletContext.getAttribute("empName"));
		System.out.println("servletContext.getAttribute(empAge) --> "+servletContext.getAttribute("empAge"));
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body>");
		writer.write("<h2>Context params are fetched successfully!!!</h2>");
		writer.write("<h2>EmpName : "+servletContext.getAttribute("empName")+"</h2>");
		writer.write("<h2>EmpAge : "+servletContext.getAttribute("empAge")+"</h2>");
		writer.write("</body></html>");
	}

}
