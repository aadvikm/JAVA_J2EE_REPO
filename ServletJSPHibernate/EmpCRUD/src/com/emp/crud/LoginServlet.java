package com.emp.crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if(uname.equalsIgnoreCase("aadvik") && pwd.equalsIgnoreCase("aadvik")){
			HttpSession session = req.getSession();
			session.setAttribute("uname", uname);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("home");
			requestDispatcher.forward(req, resp);
		}
		else{
			writer.write("<html>");
			writer.write("<head>");
			writer.write("<meta charset=\"ISO-8859-1\">");
			writer.write("<title>Login Page</title>");
			writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
			writer.write("</head>");
			writer.write("<script type='text/javascript' src='js/login.js'></script>");
			writer.write("<body>");
			writer.write("<form id='loginForm' name='loginForm'>");
			writer.write("<img src=\"img/emp_banner1.gif\" style='width:800px;height:150px;'>");
			writer.write("<h2>Invalid username or password. Pleast try again.</h2>");
			writer.write("<table>");
			writer.write("<tr>");
			writer.write("<td>UserName: </td>");
			writer.write("<td><input type='text' id='uname' name='uname' value=''/></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td>Password: </td>");
			writer.write("<td><input type='password' id='pwd' name='pwd' value=''/></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td colspan=2>");
			writer.write("<input type='button' onclick='login()' class='button button2' value='Login'/>&nbsp;<input type='button' onclick='clearForm()' class='button button2' value='Clear'/>");
			writer.write("</td>");
			writer.write("</tr>");
			writer.write("</table>");
			writer.write("</form>");
			writer.write("</body>");
			writer.write("</html>");
		}
	}

	
}
