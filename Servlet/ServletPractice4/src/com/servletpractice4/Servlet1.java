package com.servletpractice4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public Servlet1() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext=getServletContext();
		servletContext.setAttribute("studName", "Eshwar");
		servletContext.setAttribute("studAge", 3);
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		writer.write("<html><body>");
		writer.write("<form method=\"get\" action=\"/ServletPractice4/servlet2\">");
		writer.write("<h2>Context params are set successfully!!!</h2>");
		writer.write("<input type=\"Submit\" value=\"InvokeNextServlet\"></input>");
		writer.write("</form>");
		writer.write("</body></html>");
	}
	
	

}
