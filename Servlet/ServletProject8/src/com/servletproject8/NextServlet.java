package com.servletproject8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NextServlet extends HttpServlet{
	
	public NextServlet() {
		super();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session == null){
			System.out.println("Redirecting to login first....");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginFailedServlet");
			requestDispatcher.forward(req, resp);
		}
		else{
			System.out.println("The unique session id in next servlet : "+session.getId());
			String age =req.getParameter("age");
			String phoneNo=req.getParameter("phoneNo");
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("<h1>Hello "+session.getAttribute("user")+",</h1>");
			printWriter.write("<form method='get' action='/ServletProject8/LogoutServlet'>");
			printWriter.write("<h1> Your Age is "+age+"</h1></br>");
			printWriter.write("<h1> Your PhoneNo is "+phoneNo+"</h1></br>");
			printWriter.write("<input type='submit' value='Logout'/>");
			printWriter.write("</form>");
			printWriter.write("</body></html>");
		}
	}

	

}
