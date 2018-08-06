package com.departmentDAO.JDBC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SavedPage extends HttpServlet{

	public SavedPage() {
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

		String deptName =req.getParameter("deptName");
		String locId =req.getParameter("locId");
		String mgrId =req.getParameter("mgrId");
		DepartmentDao deptDao =new DepartmentDaoImpl();
		DepartmentEntity deptEntity =new DepartmentEntity();
		//deptEntity.setDeptId(Integer.parseInt(deptId));
		deptEntity.setDeptName(deptName);
		deptEntity.setLocationId(Integer.parseInt(locId));
		deptEntity.setManagerId(Integer.parseInt(mgrId));
		deptEntity = deptDao.saveDepartment(deptEntity);
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if(deptEntity != null){
			writer.write("<html><body bgcolor='lightpink'>");
			writer.write("<h3>Hi "+req.getSession().getAttribute("username")+" ,</h3>");
			writer.write("<h3>Dept Id "+deptEntity.getDeptId()+" Successfully Created..!!</h3>");
			writer.write("<form method='post' action=/DepartmentDAO_JDBC/createDept>");
			writer.write("<input type ='submit' value='Go Back'></input>");
			writer.write("</form>");
			writer.write("</br>");
			writer.write("<form method ='post' action='/DepartmentDAO_JDBC/logoutServlet'>");
			writer.write("<input type ='submit' value='Logout'></input>");
			writer.write("</form>");
			writer.write("</body></html>");
		}
		else{
			//TODO: write 
			//Error occured while saving. Please try again.
			writer.write("<html><body bgcolor='lightpink'>");
			writer.write("<script type='text/javascript' src='js/savedpage.js'></script>");
			writer.write("<h3>Hi "+req.getSession().getAttribute("username")+" ,</h3>");
			writer.write("<h3>Error occured while saving. Please try again.</h3>");
			writer.write("<form id='savedFormId' name='savedFormId' method='post' action='/DepartmentDAO_JDBC/savedPage'>");
			writer.write("Dept Name : <input type='text' name='deptName' id='deptName'></input></br>");
			writer.write("Location Id : <input type='text' name='locId' id='locId'></input></br>");
			writer.write("Manager Id : <input type='text' name='mgrId' id='mgrId'></input></br>");
			writer.write("</br>");
			writer.write("<input type='button' onclick='saveDept()' value='Save'></input>");
			writer.write("<input id='goBackBtn' name='goBackBtn' type ='button' onClick='goBack()' value='Go Back'></input>");
			writer.write("</form>");
			writer.write("</br>");
			//writer.write("<form method ='post' action='/DepartmentDAO_JDBC/deptPage'>");
			
			//writer.write("</form>");
			writer.write("</body></html>");
		}
		
		
	}
	
	

}
