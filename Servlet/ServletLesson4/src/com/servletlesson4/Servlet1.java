package com.servletlesson4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("empName", new String("Aadvik"));
		servletContext.setAttribute("empAge", 0);
		System.out.println("Attributes are successfuly put in the context scope...");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body>");
		writer.write("<form method=\"get\" action=\"/ServletLesson4/servlet2\">");
		writer.write("<h2>Context params are set successfully!!!</h2>");
		writer.write("<input type='submit' value='invokeNextServlet'/>");
		writer.write("</form>");
		writer.write("</body></html>");
	}
	
	
	

}
