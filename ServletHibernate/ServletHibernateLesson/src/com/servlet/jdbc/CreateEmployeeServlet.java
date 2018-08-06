package com.servlet.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateEmployeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
				resp.setContentType("text/html");
				PrintWriter writer = resp.getWriter();
				writer.write("<html><head><link rel='stylesheet' type=\"text/css\" href=\"css/mytheme.css\"></head><script type='text/javascript' src='js/employeedetail.js'></script><body>");
				writer.write("<form id='empForm' name='empForm' method='get' action='/ServletHibernateLesson/getEmpDetail'>");
				writer.write("<table>");
				writer.write("<tr><td colspan=2><div>");
				writer.write("Emp Id : <input type='text' name='empId' id='empId' value=''></input>");
				writer.write("<input type='submit' class='button button2' value='Search Employee'/>");
				writer.write("<input type='button' onclick='createEmployee()' class='button button2' value='Create Employee'/>");
				writer.write("</div></td></tr>");
				writer.write("<tr><td><div>");
				writer.write("<label for='firstName'>Fist Name:</label>");
				writer.write("<input type='text' id='firstName' name='firstName' value=''");
				writer.write("</div></td>");
				writer.write("<td><div>");
				writer.write("<label for='mail'>Last Name:</label>");
				writer.write("<input type='text' id='lastName' name='lastName' value=''");
				writer.write("</div></td></tr>");
				writer.write("<tr><td><div>");
				writer.write("<label for='name'>Hire Date:</label>");
				writer.write("<input type='text' id='hireDate' name='hireDate' value=''");
				writer.write("</div></td>");
				writer.write("<td><div>");
				writer.write("<label for='mail'>E-Mail:</label>");
				writer.write("<input type='text' id='email' name='email' value=''");
				writer.write("</div></td></tr>");
				writer.write("<tr><td><div>");
				writer.write("<label for='name'>Department Name:</label>");
				writer.write("<input type='text' id='departmentId' name='departmentId' value=''");
				writer.write("</div></td>");
				writer.write("<td><div>");
				writer.write("<label for='mail'>Salary:</label>");
				writer.write("<input type='text' id='salary' name='salary' value=''");
				writer.write("</div></td></tr>");
				writer.write("<tr><td><div>");
				writer.write("<label for='name'>Job Id:</label>");
				writer.write("<input type='text' id='jobId' name='jobId' value=''");
				writer.write("</div></td>");
				writer.write("<td><div>");
				writer.write("<label for='mail'>Manager Id:</label>");
				writer.write("<input type='text' id='managerId' name='managerId' value=''");
				writer.write("</div></td></tr>");
				writer.write("<tr><td colspan=2><div>");
				writer.write("<input type='button' class='button button2' onclick='saveEmp()' value='Save'/>&nbsp;");
				writer.write("<input type='button' class='button button2' onclick='clearEmp()' value='Clear'/>&nbsp;");
				writer.write("</div></td></tr>");
				writer.write("</form>");
				writer.write("</body></html>");
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
	}

	

}
