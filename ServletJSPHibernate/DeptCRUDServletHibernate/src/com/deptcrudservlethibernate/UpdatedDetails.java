package com.deptcrudservlethibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdatedDetails extends HttpServlet {

	public UpdatedDetails() {
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
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String deptId =req.getParameter("deptId");
		Session hSession = getHibernateSession();
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		if(deptId == null || deptId.trim().length() == 0){
			writer.write("<html>");
			writer.write("<head>");
			writer.write("<meta charset=\"ISO-8859-1\">");
			writer.write("<title>Update Dept Page</title>");
			writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
			writer.write("</head>");
			writer.write("<script type='text/javascript' src='js/updateDeptPage.js'></script>");
			writer.write("<body>");
			writer.write("<form id='updateDeptPage' name='updateDeptPage'>");
			writer.write("<img src='images/deptimage.jpg' style='width:800px;height:150px;'>");
			writer.write("Welcome  "+username+",<br/><br/>");
			writer.write("<table>");
			writer.write("<tr>");
			writer.write("<td colspan=3><h1>Department not found for "+deptId+".Pls try again..!!</h1></td>");
			writer.write("</tr>");
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
		else{
			DepartmentEntity deptEntity =(DepartmentEntity)hSession.get(DepartmentEntity.class, new Integer(deptId));
			if(deptEntity !=null){
				writer.write("<html>");
				writer.write("<head>");
				writer.write("<meta charset=\"ISO-8859-1\">");
				writer.write("<title>Update Dept Page</title>");
				writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
				writer.write("</head>");
				writer.write("<script type='text/javascript' src='js/updateDeptPage.js'></script>");
				writer.write("<body>");
				writer.write("<form id='updateDeptPage' name='updateDeptPage'>");
				writer.write("<img src='images/deptimage.jpg' style='width:800px;height:150px;'>");
				writer.write("Welcome  "+username+",<br/><br/>");
				writer.write("<table>");
				writer.write("<tr>");
				writer.write("<td>Dept Id: </td>");
				writer.write("<td><input type='text' id='deptId' name='deptId' value='"+deptId+"'/></td>");
				writer.write("</tr>");
				writer.write("<tr>");
				writer.write("<td>Department Name: </td>");
				writer.write("<td><input type='text' id='deptName' name='deptName' value='"+deptEntity.getDeptName()+"'/></td>");
				writer.write("</tr>");
				writer.write("<tr>");
				writer.write("<td>Location Id: </td>");
				writer.write("<td><input type='text' id='locationId' name='locationId' value='"+deptEntity.getLocationId()+"'/></td>");
				writer.write("</tr>");
				writer.write("<tr>");
				writer.write("<td>Manager Id: </td>");
				writer.write("<td><input type='text' id='managerId' name='managerId' value='"+deptEntity.getManagerId()+"'/></td>");
				writer.write("</tr>");
				writer.write("<tr>");
				writer.write("<td colspan=3><input type='button'  class='button button2' onclick ='updateDept()' value='Update'/></td>");
				writer.write("<td colspan=3><input type='button' class=\"button button2\" onclick='goHome()' value='Go Home'/></td>");
				writer.write("</tr>");
				writer.write("</table>");
				writer.write("</form>");
				writer.write("</body>");
				writer.write("</html>");
			}
		}
		
	}

	
	private Session getHibernateSession(){
		//creating configuration object  
	    Configuration cfg=new Configuration();  
	    //populates the data of the configuration file
	    cfg.configure("hibernate.cfg.xml");   
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession();
	    return session;
	}


}
