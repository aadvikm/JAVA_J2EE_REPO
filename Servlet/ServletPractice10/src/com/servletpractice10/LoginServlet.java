package com.servletpractice10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		boolean authentication = false;
		if(userName.equalsIgnoreCase("Aadvik")){
			if(password.equals("Welcome123")){
				authentication = true;
			}
		}
		else if(userName.equalsIgnoreCase("Muthu")){
			if(password.equals("Muthu")){
				authentication = true;
			}
		}
		System.out.println("Context attribute is : "+getServletContext().getAttribute("appName"));
		if(authentication){
			
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(5000);
			System.out.println("The unique session id : "+session.getId());
			session.setAttribute("user", userName);
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("Hello "+userName+",");
			printWriter.write("<form method='get' action='/ServletPractice10/NextServlet'>");
			printWriter.write("<h1>Page 1.....</h1>");
			printWriter.write("<h1>Total No User Logged in so far : "+getServletContext().getAttribute("totNoOfUserLoggedIn")+"</h1>");
			printWriter.write("<h1>Total No of Current User Logged into application : "+getServletContext().getAttribute("currentActiveNoOfUser")+"</h1>");
			printWriter.write("<input type='submit' value='NextPage'/>");
			printWriter.write("</form>");
			printWriter.write("</body></html>");
		}
		else{
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginFailedServlet");
			requestDispatcher.forward(req, resp);
		}
	}

}
