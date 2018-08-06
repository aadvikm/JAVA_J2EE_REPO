package com.servlethibernateproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empId = req.getParameter("empId");
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
						Transaction tx = session.beginTransaction();
						session.delete(emp);
						tx.commit();
						System.out.println("Deleted Successfully!!!!!");
						found = true;
						
					}
					if (!found) {
						writer.write("<tr><td colspan=2><div>");
						writer.write("<h1>No Record found for Emp Id :  " + empId + ". Please try with different Id.</h1>");
						writer.write("</div></td></tr>");
					}
					else{
						writer.write("<tr><td colspan=2><div>");
						writer.write("<h1>Employee Detail Deleted Successfully!!!</h1>");
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
