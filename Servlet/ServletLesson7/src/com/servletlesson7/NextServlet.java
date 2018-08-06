package com.servletlesson7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NextServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(" The user name is : "+req.getParameter("user"));
		PrintWriter printWriter = resp.getWriter();
		printWriter.write("<html><body>");
		printWriter.write("Hello "+req.getParameter("user")+",");
		printWriter.write("<form method='get' action='/ServletLesson7/LogoutServlet'>");
		printWriter.write("<h1>Page 2.....</h1>");
		//printWriter.write("<input type='submit' value='Logout'/>");
		printWriter.write("<a href='LogoutServlet'>Logout</a>");
		printWriter.write("</form>");
		printWriter.write("</body></html>");
		
	}


}
