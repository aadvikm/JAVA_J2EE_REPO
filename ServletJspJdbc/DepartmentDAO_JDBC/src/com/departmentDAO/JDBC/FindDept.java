package com.departmentDAO.JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindDept extends HttpServlet{

	public FindDept() {
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
		String deptId = req.getParameter("deptId");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		DepartmentDao deptDao =new DepartmentDaoImpl();
		DepartmentEntity deptEntity=(DepartmentEntity)deptDao.fetchDepartment(Integer.parseInt(deptId));
			if(deptEntity != null){
				writer.write("<html><body bgcolor='lightpink'>");
				writer.write("<h3>Hi "+req.getSession().getAttribute("username")+" ,</h3>");
				writer.write("<form method ='post' action='/DepartmentDAO_JDBC/deptPage'>");
				writer.write("<h3>Dept Id : "+deptEntity.getDeptId()+"</h3>");
				writer.write("<h3>Dept Name : "+deptEntity.getDeptName()+"</h3>");
				writer.write("<h3>Location Id: "+deptEntity.getLocationId()+"</h3>");
				writer.write("<h3>Manager Id: "+deptEntity.getManagerId()+"</h3>");
				writer.write("<input type ='submit' value='Go Back'></input>");
				writer.write("</form>");
				writer.write("<form method ='post' action='/DepartmentDAO_JDBC/logoutServlet'>");
				writer.write("<input type ='submit' value='Logout'></input>");
				writer.write("</form>");
				writer.write("</body></html>");
			}
			else{
				writer.write("<html><body bgcolor='lightpink'>");
				writer.write("<h1>Unable to get dept detail. Please try again.</h1>");
				writer.write("<form method='post' action ='/DepartmentDAO_JDBC/findDept'>");
				writer.write("Dept Id : <input type='text' name='deptId' id='deptId'></input>");
				writer.write("<input type ='submit' value='Get Dept Details'></input>");
				writer.write("</form>");
				writer.write("</body></html>");
			}
			
		
		
	}
	
}
