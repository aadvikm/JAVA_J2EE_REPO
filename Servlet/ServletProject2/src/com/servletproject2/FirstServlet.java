package com.servletproject2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	public FirstServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext serv =getServletContext();
		serv.setAttribute("Name", "Brindha");
		serv.setAttribute("Age", 26);
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		writer.write("<html><body>");
		writer.write("<form method=\"get\" action=\"/ServletProject2/secondServlet\">");
		writer.write("<h2>Context params are set successfully!!!</h2>");
		writer.write("<input type=\"Submit\" value=\"InvokeNextServlet\"></input>");
		writer.write("</form>");
		writer.write("</body></html>");
	}
	
	
	
}
