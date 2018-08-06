package com.ServletPracticeHttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		boolean authentication = false;
		if (userName.equalsIgnoreCase("Aadvik")) {
			if (password.equals("Welcome123")) {
				authentication = true;
			}
		} else if (userName.equalsIgnoreCase("Muthu")) {
			if (password.equals("Muthu")) {
				authentication = true;
			}
		}
		if (authentication) {
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(5000);
			System.out.println("The unique session id : " + session.getId());
			session.setAttribute("user", userName);
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("<h1>Hello " + userName + ",</h1>");
			printWriter.write("<form method='post' action='/ServletPracticeHttpSession/NextServlet'>");
			printWriter.write("Enter Your Age : <input type ='text' id ='age' name='age'/></br>");
			printWriter.write("Enter Your PhoneNo : <input type ='text' id ='phoneNo' name='phoneNo'/></br>");
			printWriter.write("<input type='submit' value='NextPage'/>");
			printWriter.write("</form>");
			printWriter.write("</body></html>");
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginFailedServlet");
			requestDispatcher.forward(req, resp);
		}
	}

}
