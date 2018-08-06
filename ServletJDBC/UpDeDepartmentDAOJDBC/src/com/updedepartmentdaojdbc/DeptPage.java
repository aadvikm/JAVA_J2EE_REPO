package com.updedepartmentdaojdbc;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter writer=resp.getWriter();
		writer.write("<html><body bgcolor='lightpink'>");
		writer.write("<script type='text/javascript' src='js/deptpage.js'></script>");
		writer.write("<h3>Hi "+req.getSession().getAttribute("username")+"</h3>");
		writer.write("<form id='deptpage' name='deptpage' method='post' action ='/UpDeDepartmentDAOJDBC/updatePage'>");
		writer.write("<label for='deptId'> Department Id :</label>");
		writer.write("<input type ='text' id='deptId' name='deptId' value=''></input> </br>");
		writer.write("<label for='deptName'> Department Name :</label>");
		writer.write("<input type ='text' id='deptName' name='deptName' value=''></input> </br>");
		writer.write("<label for='locId'> Location Id :</label>");
		writer.write("<input type ='text' id='locId' name='locId' value=''></input> </br>");
		writer.write("<label for='mgrId'> Manager Id :</label>");
		writer.write("<input type ='text' id='mgrId' name='mgrId' value=''></input> </br>");
		writer.write("<input type='button' id='update' name='update' value='Update' onClick='updateDept()'></input>");
		writer.write("<input type='button' id='delete' name='delete' value='Delete' onClick='deleteDept()'></input>");
		writer.write("</form>");
		writer.write("</body></html>");
	}

	
	
}
