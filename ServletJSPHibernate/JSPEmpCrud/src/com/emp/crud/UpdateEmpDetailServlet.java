package com.emp.crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmpDetailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String uname = (String) session.getAttribute("uname");
		String empId = req.getParameter("empId");
		Session hSession = getHibernateSession();
		Employee employee = (Employee) hSession.get(Employee.class, new Long(empId));
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if(employee != null){
			writer.write("<html>");
			writer.write("<head>");
			writer.write("<meta charset=\"ISO-8859-1\">");
			writer.write("<title>Emp Page</title>");
			writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
			writer.write("</head>");
			writer.write("<script type='text/javascript' src='js/updateempdetail.js'></script>");
			writer.write("<body>");
			writer.write("<form id='getEmpPageForm' name='getEmpPageForm'>");
			writer.write("<img src=\"img/emp_banner1.gif\" style='width:800px;height:150px;'>");
			writer.write("Welcome  "+uname+",<br/><br/>");
			writer.write("<table>");
			writer.write("<tr>");
			writer.write("<td>Emp Id: </td>");
			writer.write("<td><input type='text' id='empId' name='empId' value='"+empId+"'/></td>");
			writer.write("<td><input type='button' class=\"button button2\" onclick='findEmp()' value='Search'/></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td>First Name: </td>");
			writer.write("<td colspan=2>"+employee.getFirstName()+"</td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td>Last Name: </td>");
			writer.write("<td colspan=2>"+employee.getLastName()+"</td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td>Salary: </td>");
			writer.write("<td colspan=2>"+employee.getSalary()+"</td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td colspan=3><input type='button' class=\"button button2\" onclick='goHome()' value='Go Home'/></td>");
			writer.write("</tr>");
			writer.write("</table>");
			writer.write("</form>");
			writer.write("</body>");
			writer.write("</html>");
		}
		else{
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
			writer.write("<td colspan=3><h1>Employee not found for "+empId+".</h1></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td>Emp Id: </td>");
			writer.write("<td><input type='text' id='empId' name='empId' value=''/></td>");
			writer.write("<td><input type='button' class=\"button button2\" onclick='findEmp()' value='Search'/></td>");
			writer.write("</tr>");
			writer.write("</table>");
			writer.write("</form>");
			writer.write("</body>");
			writer.write("</html>");
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
