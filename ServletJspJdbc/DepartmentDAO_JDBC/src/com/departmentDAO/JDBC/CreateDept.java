package com.departmentDAO.JDBC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateDept extends HttpServlet{

	public CreateDept() {
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
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body bgcolor='lightpink'>");
		writer.write("<h3>Hi "+req.getSession().getAttribute("username")+" ,</h3>");
		writer.write("<form method='post' action='/DepartmentDAO_JDBC/savedPage'>");
		writer.write("Dept Name : <input type='text' name='deptName' id='deptName'></input></br>");
		writer.write("Location Id : <input type='text' name='locId' id='locId'></input></br>");
		writer.write("Manager Id : <input type='text' name='mgrId' id='mgrId'></input></br>");
		writer.write("</br>");
		writer.write("<input type='submit' value='Save'></input>");
		writer.write("</form>");
		writer.write("</br>");
		writer.write("<form method ='post' action='/DepartmentDAO_JDBC/deptPage'>");
		writer.write("<input type ='submit' value='Go Back'></input>");
		writer.write("</form>");
		writer.write("</body></html>");
		
	}
}
