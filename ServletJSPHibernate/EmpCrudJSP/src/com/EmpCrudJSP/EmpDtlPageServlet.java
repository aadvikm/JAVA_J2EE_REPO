package com.EmpCrudJSP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmpDtlPageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String uname = (String) session.getAttribute("uname");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<meta charset=\"ISO-8859-1\">");
		writer.write("<title>Emp Page</title>");
		writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
		writer.write("</head>");
		writer.write("<script type='text/javascript' src='js/getempdetail.js'></script>");
		writer.write("<body>");
		writer.write("<form id='getEmpPageForm' name='getEmpPageForm'>");
		writer.write("<img src=\"img/emp_banner1.gif\" style='width:800px;height:150px;'>");
		writer.write("Welcome  "+uname+",<br/><br/>");
		writer.write("<table>");
		writer.write("<tr>");
		writer.write("<td>Emp Id: </td>");
		writer.write("<td><input type='text' id='empId' name='empId' value=''/></td>");
		writer.write("<td><input type='button' class='button button2' onClick='findEmp()' value='Search'/></td>");
		writer.write("</tr>");
		writer.write("</table>");
		writer.write("</form>");
		writer.write("</body>");
		writer.write("</html>");
	}


}
