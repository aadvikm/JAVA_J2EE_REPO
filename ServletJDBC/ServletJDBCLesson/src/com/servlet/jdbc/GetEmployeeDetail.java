package com.servlet.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeDetail extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empId = req.getParameter("empId");
		Connection conn = getDBConnection();
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if(empId == null || empId.trim().length() == 0 || conn == null){
			writer.write("<html><body>");
			writer.write("<h1>Unable to get emp detail. Please try again.</h1>");
			writer.write("<form id='empForm' name='empForm' method='get' action='/ServletJDBCLesson/getEmpDetail'>");
			writer.write("Emp Id : <input type='text' name='empId' id='empId'></input>");
			writer.write("<input type='submit' value='Get Emp Detail'/>");
			writer.write("</form>");
			writer.write("</body></html>");
		}
		else{
			try{
				 Statement stmt = conn.createStatement();
		          ResultSet  rs = stmt.executeQuery("SELECT FIRST_NAME, LAST_NAME, SALARY, HIRE_DATE, MANAGER_ID FROM EMPLOYEES WHERE EMPLOYEE_ID = "+empId);
		          writer.write("<html><body>");
		          SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		          boolean found = false;
		          while(rs.next()){
		        	  found = true;
		        	  writer.write("<h1>First Name : "+rs.getString(1)+"</h1>");
		        	  writer.write("<h1>Last NAme : "+rs.getString(2)+"</h1>");
		        	  writer.write("<h1>Salary  : "+rs.getString(3)+"</h1>");
		        	  writer.write("<h1>Hire Date : "+sdf.format(rs.getDate(4))+"</h1>");
		        	  writer.write("<h1>Manager Id : "+rs.getString(5)+"</h1>");
		          }
		          if(!found){
		        	  writer.write("<h1>No Record found for Emp Id :  "+empId+". Please try with different Id.</h1>");
		          }
		          writer.write("<form id='empForm' name='empForm' method='get' action='/ServletJDBCLesson/getEmpDetail'>");
					writer.write("Emp Id : <input type='text' name='empId' id='empId'></input>");
					writer.write("<input type='submit' value='Get Emp Detail'/>");
					writer.write("</form>");
					writer.write("</body></html>");
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			finally{
				try{
				conn.close();
				}
				catch(Exception ex){
					//do nothing....
				}
			}
			
		}
	}
	
	private Connection getDBConnection(){
		try{
		System.out.println("Inside get connection method...");
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
        System.out.println("Connetion : "+con);
        return con;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	

}
