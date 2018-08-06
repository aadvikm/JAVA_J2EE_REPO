package com.servlethibernateproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empId = req.getParameter("empId");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String hireDate = req.getParameter("hireDate");
		String email = req.getParameter("email");
		String departmentId = req.getParameter("departmentId");
		String salary = req.getParameter("salary");
		salary = (salary != null ? salary.replace("$", "") : salary);
		String jobId = req.getParameter("jobId");
		String managerId = req.getParameter("managerId");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		DecimalFormat dFormat = new DecimalFormat("#.00");
		Session session = getHibernateSession();
		try{
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			if(empId == null || empId.trim().length() == 0 || session == null){
				writer.write("<html><head><link rel='stylesheet' type=\"text/css\" href=\"css/mytheme.css\"></head><script type='text/javascript' src='js/employeedetail.js'></script><body>");
				writer.write("<h1>Unable to get emp detail. Please try again.</h1>");
				writer.write("<form id='empForm' name='empForm' method='get' action='/ServletHibernateProject/getEmpDetail'>");
				writer.write("Emp Id : <input type='text' name='empId' id='empId' value='"+empId+"'></input>");
				writer.write("<input type='submit' class='button button2' value='Search Employee'/>");
				writer.write("<input type='button' onclick='createEmployee()' class='button button2' value='Create Employee'/>");
				writer.write("</form>");
				writer.write("</body></html>");
			}
			else{
				
					Employee emp = null;
					Transaction tx = session.beginTransaction();
					emp = (Employee) session.get(Employee.class, new Long(empId));
					writer.write("<html><head><link rel='stylesheet' type=\"text/css\" href=\"css/mytheme.css\"></head><script type='text/javascript' src='js/employeedetail.js'></script><body>");
					boolean found = false;
					writer.write("<form id='empForm' name='empForm' method='get' action='/ServletHibernateProject/getEmpDetail'>");
					writer.write("<table>");
					writer.write("<tr><td colspan=2><div>");
					writer.write("Emp Id : <input type='text' name='empId' id='empId' value='"+empId+"'></input>");
					writer.write("<input type='submit' class='button button2' value='Search Employee'/>");
					writer.write("<input type='button' onclick='createEmployee()' class='button button2' value='Create Employee'/>");
					writer.write("</div></td></tr>");
					if (emp != null) {
						emp.setFirstName(firstName);
						emp.setLastName(lastName);
						emp.setHireDate(hireDate == null ? null : sdf.parse(hireDate));
						emp.setEmail(email);
						emp.setDepartmentId(departmentId == null ? null : new Long(departmentId));
						emp.setSalary(salary == null ? null : new BigDecimal((double) dFormat.parse(salary)));
						emp.setJobId(jobId);
						emp.setManagerId(managerId == null || managerId.equals("null") ? null : new Long(managerId));
						session.update(emp);
						tx.commit();
						System.out.println("Comittted!!!!!");
						found = true;
						writer.write("<tr><td><div>");
						writer.write("<label for='name'>Fist Name:</label>");
						writer.write("<input type='text' id='firstName' name='firstName' value='" + emp.getFirstName() + "'");
						writer.write("</div></td>");
						writer.write("<td><div>");
						writer.write("<label for='mail'>Last Name:</label>");
						writer.write("<input type='text' id='lastName' name='lastName' value='" + emp.getLastName() + "'");
						writer.write("</div></td></tr>");
						writer.write("<tr><td><div>");
						writer.write("<label for='name'>Hire Date:</label>");
						writer.write("<input type='text' id='hireDate' name='hireDate' value='" + sdf.format(emp.getHireDate()) + "'");
						writer.write("</div></td>");
						writer.write("<td><div>");
						writer.write("<label for='mail'>E-Mail:</label>");
						writer.write("<input type='text' id='email' name='email' value='" + emp.getEmail() + "'");
						writer.write("</div></td></tr>");
						writer.write("<tr><td><div>");
						writer.write("<label for='name'>Department Name:</label>");
						writer.write("<input type='text' id='departmentName' name='departmentName' value='" + emp.getDepartmentId() + "'");
						writer.write("</div></td>");
						writer.write("<td><div>");
						writer.write("<label for='mail'>Salary:</label>");
						writer.write("<input type='text' id='salary' name='salary' value='" + "$" + dFormat.format(emp.getSalary())  + "'");
						writer.write("</div></td></tr>");
						writer.write("<tr><td><div>");
						writer.write("<label for='name'>Job Id:</label>");
						writer.write("<input type='text' id='jobId' name='jobId' value='" + emp.getJobId() + "'");
						writer.write("</div></td>");
						writer.write("<td><div>");
						writer.write("<label for='mail'>Manager Id:</label>");
						writer.write("<input type='text' id='managerId' name='managerId' value='" + emp.getManagerId() + "'");
						writer.write("</div></td></tr>");
					}
					if (!found) {
						writer.write("<tr><td colspan=2><div>");
						writer.write("<h1>No Record found for Emp Id :  " + empId + ". Please try with different Id.</h1>");
						writer.write("</div></td></tr>");
					}
					else{
						writer.write("<tr><td colspan=2><div>");
						writer.write("<input type='button' class='button button2' onclick='updateEmp()' value='Update Employee'/>&nbsp;");
						writer.write("<input type='button' class='button button2' onclick='deleteEmp()' value='Delete Employee'/>");
						writer.write("</div></td></tr>");
						writer.write("<tr><td colspan=2><div>");
						writer.write("<h1>Employee Detail Updated Successfully!!!</h1>");
						writer.write("</div></td></tr>");
					}
					writer.write("</form>");
					writer.write("</body></html>");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			session.close();
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
