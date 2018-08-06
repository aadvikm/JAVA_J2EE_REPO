package com.servletlesson9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NextServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//System.out.println(" The user name is : "+req.getParameter("user"));
		HttpSession session = req.getSession(false);
		if(session == null){
			System.out.println("Redirecting to login first....");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginFailedServlet");
			requestDispatcher.forward(req, resp);
		}
		else{
			System.out.println("The unique session id in next servlet : "+session.getId());
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("Hello "+session.getAttribute("user")+",");
			printWriter.write("<form method='get' action='/ServletLesson9/LogoutServlet'>");
			printWriter.write("<h1>Page 2.....</h1>");
			printWriter.write("<h1>Total No User Logged in so far : "+getServletContext().getAttribute("totNoOfUserLoggedIn")+"</h1>");
			printWriter.write("<h1>Total No of Current User Logged into application : "+getServletContext().getAttribute("currentActiveNoOfUser")+"</h1>");
			printWriter.write("<input type='submit' value='Logout'/>");
			//printWriter.write("<a href='LogoutServlet'>Logout</a>");
			printWriter.write("</form>");
			printWriter.write("</body></html>");
		}
		
		
	}


}
