package com.deptcrudservlethibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteDepartment extends HttpServlet{

	public DeleteDepartment() {
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
		PrintWriter writer=resp.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<meta charset=\"ISO-8859-1\">");
		writer.write("<title>Delete Dept Page</title>");
		writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
		writer.write("</head>");
		writer.write("<script type='text/javascript' src='js/deleteDeptPage.js'></script>");
		writer.write("<body>");
		writer.write("<form id='deleteDeptPage' name='deleteDeptPage'>");
		writer.write("<img src='images/deptimage.jpg' style='width:800px;height:150px;'>");
		writer.write("Welcome  "+username+",<br/><br/>");
		writer.write("<table>");
		writer.write("<tr>");
		writer.write("<td>Dept Id: </td>");
		writer.write("<td><input type='text' id='deptId' name='deptId' value=''/></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td><input type='button'  class='button button2' onclick ='findDept()' value='Search'/></td>");
		writer.write("<td><input type='button' class=\"button button2\" onclick='goHome()' value='Go Home'/></td>");
		writer.write("</tr>");
		writer.write("</table>");
		writer.write("</form>");
		writer.write("</body>");
		writer.write("</html>");
	}

}
