package com.departmentsJDBC;

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

public class DeptDetails extends HttpServlet {

	public DeptDetails() {
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
		Connection conn = getDBConnection();
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if(deptId == null || deptId.trim().length() == 0 || conn == null){
			writer.write("<html><body bgcolor='lightyellow'>");
			writer.write("<h1>Unable to get dept detail. Please try again.</h1>");
			writer.write("<form method='get' action='/DepartmentsJDBC/deptDetails'>");
			writer.write("Dept Id : <input type='text' name='deptId' id='deptId'></input> </br>");
			writer.write("<input type='submit' value='Get Dept Detail'/>");
			writer.write("</form>");
			writer.write("</body></html>");
		}
		else{
			try{
				Statement stmt = conn.createStatement();
				System.out.println("dept id: "+ deptId);
				ResultSet rs =stmt.executeQuery("SELECT DEPARTMENT_NAME, LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID ="+deptId);
				System.out.println("after rs dept id:"+ deptId); 
				writer.write("<html><body>");
		          boolean found = false;
		          while(rs.next()){
		        	  found = true;
		        	  writer.write("<h1>Department Name : "+rs.getString(1)+"</h1>");
		        	  writer.write("<h1>Location Id : "+rs.getString(2)+"</h1>");
		        	
		          }
		          if(!found){
		        	  writer.write("<h1>No Record found for Dept Id :  "+deptId+". Please try with different Id.</h1>");
		          }
		      	writer.write("<form method='get' action='/DepartmentsJDBC/deptDetails'>");
				writer.write("Dept Id : <input type='text' name='deptId' id='deptId'></input> </br>");
				writer.write("<input type='submit' value='Get Dept Detail'/>");
				writer.write("</form>");
				
				writer.write("<form method='post' action='/DepartmentsJDBC/logoutServlet'>");
				writer.write("<input type='submit' value='Next'/>");
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
				catch(Exception e){
					e.printStackTrace();
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
