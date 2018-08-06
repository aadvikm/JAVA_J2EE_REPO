package com.departmentDAO.JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptPage extends HttpServlet{

	public DeptPage() {
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
		writer.write("<html><body bgcolor='lightyellow'>");
		writer.write("<h3>Hi " +req.getSession().getAttribute("username")+" ,</h3>");
		writer.write("<tr>");
		writer.write("<form method='post' action ='/DepartmentDAO_JDBC/createDept'>");
		writer.write("<input type ='submit' value='Create New Dept'></input>");
		writer.write("</form>");
		writer.write("</br>");
		writer.write("<form method='post' action ='/DepartmentDAO_JDBC/findDept'>");
		writer.write("Dept Id : <input type='text' name='deptId' id='deptId'></input></br>");
		writer.write("<input type ='submit' value='Get Dept Details'></input>");
		writer.write("</form>");
		writer.write("</tr>");
		writer.write("</body></html>");
	}
	
	
}
