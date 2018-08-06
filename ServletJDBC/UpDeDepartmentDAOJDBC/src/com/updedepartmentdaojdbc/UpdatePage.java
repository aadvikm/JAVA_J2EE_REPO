package com.updedepartmentdaojdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePage extends HttpServlet {

	public UpdatePage() {
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
		String deptName = req.getParameter("deptName");
		String locId = req.getParameter("locId");
		String mgrId = req.getParameter("mgrId");

		try {
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			if (deptId == null || deptId.trim().length() == 0) {
				writer.write("<html><body bgcolor='lightpink'>");
				writer.write("<script type='text/javascript' src='js/deptpage.js'></script>");
				writer.write("<h3>Hi " + req.getSession().getAttribute("username") + "</h3>");
				writer.write("<h1>Unable to get dept detail. Please try again.</h1>");
				writer.write(
						"<form id='deptpage' name='deptpage' method='post' action ='/UpDeDepartmentDAOJDBC/updatePage'>");
				writer.write("<label for='deptId'> Department Id :</label>");
				writer.write("<input type ='text' id='deptId' name='deptId' value=''></input> </br>");
				writer.write("<label for='deptName'> Department Name :</label>");
				writer.write("<input type ='text' id='deptName' name='deptName' value=''></input> </br>");
				writer.write("<label for='locId'> Location Id :</label>");
				writer.write("<input type ='text' id='locId' name='locId' value=''></input> </br>");
				writer.write("<label for='mgrId'> Manager Id :</label>");
				writer.write("Mgr Id :<input type ='text' id='mgrId' name='mgrId' value=''></input> </br>");
				writer.write(
						"<input type='button' id='update' name='update' value='Update' onClick='updateDept()'></input>");
				writer.write(
						"<input type='button' id='delete' name='delete' value='Delete' onClick='deleteDept()'></input>");
				writer.write(
						"<input type='button' id='logout' name='logout' value='Logout' onClick='logout()'></input>");
				writer.write("</form>");
				writer.write("</body></html>");
			} else {
				DepartmentDao deptDao = new DepartmentDaoImpl();
				DepartmentEntity deptEntity = new DepartmentEntity();
				
				writer.write("<html><body bgcolor='lightpink'>");
				writer.write("<script type='text/javascript' src='js/deptpage.js'></script>");
				writer.write("<h3>Hi " + req.getSession().getAttribute("username") + " ,</h3>");
				writer.write("<form id='deptpage' name='deptpage' method='post' action='/UpDeDepartmentDAOJDBC/updatePage'>");
				if (deptId != null) {

					deptEntity.setDeptId(Integer.parseInt(deptId));
					deptEntity.setDeptName(deptName);
					deptEntity.setLocationId(Integer.parseInt(locId));
					deptEntity.setManagerId(Integer.parseInt(mgrId));
					deptDao.updateDepartment(deptEntity);

					writer.write("<label for='deptId'> Department Id :</label>");
					writer.write("<input type ='text' id='deptId' name='deptId' value='" + deptEntity.getDeptId()+ "'></input> </br>");
					writer.write("<label for='deptName'> Department Name :</label>");
					writer.write("<input type ='text' id='deptName' name='deptName' value='" + deptEntity.getDeptName()+ "'></input> </br>");
					writer.write("<label for='locId'> Location Id :</label>");
					writer.write("<input type ='text' id='locId' name='locId' value='" + deptEntity.getLocationId()+ "'></input> </br>");
					writer.write("<label for='mgrId'> Manager Id :</label>");
					writer.write("<input type ='text' id='mgrId' name='mgrId' value='" + deptEntity.getManagerId()+ "'></input> </br>");
					writer.write("<input type='button' id='update' name='update' value='Update' onClick='updateDept()'></input>");
					writer.write("<input type='button' id='delete' name='delete' value='Delete' onClick='deleteDept()'></input>");
					writer.write("<input type='button' id='logout' name='logout' value='Logout' onClick='logout()'></input>");
					writer.write("<h1>Department Detail Updated Successfully!!!</h1>");
					writer.write("</form>");
					writer.write("</body></html>");
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
