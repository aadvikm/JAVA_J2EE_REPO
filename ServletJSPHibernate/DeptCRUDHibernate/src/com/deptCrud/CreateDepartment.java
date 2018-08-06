package com.deptCrud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateDepartment extends HttpServlet {

	public CreateDepartment() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession();
		String username =(String)session.getAttribute("username");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<meta charset=\"ISO-8859-1\">");
		writer.write("<title>Create Dept Page</title>");
		writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
		writer.write("</head>");
		writer.write("<script type='text/javascript' src='js/createDeptPage.js'></script>");
		writer.write("<body>");
		writer.write("<form id='createDeptPage' name='createDeptPage'>");
		writer.write("<img src='images/deptimage.jpg' style='width:800px;height:150px;'>");
		writer.write("Welcome  "+username+",<br/><br/>");
		writer.write("<table>");
		writer.write("<tr>");
		writer.write("<td>Dept Name: </td>");
		writer.write("<td><input type='text' id='deptName' name='deptName' value=''/></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>Manager Id: </td>");
		writer.write("<td><input type='text' id='managerId' name='managerId' value=''/></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>Location Id: </td>");
		writer.write("<td><input type='text' id='locationId' name='locationId' value=''/></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td><input type='button'  class='button button2' onclick ='createDepartment()' value='Create'/><></td>");
		writer.write("<td><input type='button' class=\"button button2\" onclick='goHome()' value='Go Home'/></td>");
		writer.write("</tr>");
		writer.write("</table>");
		writer.write("</form>");
		writer.write("</body>");
		writer.write("</html>");
	}

}
