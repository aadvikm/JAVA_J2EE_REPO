package com.departmentsJDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptPage extends HttpServlet {

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
	
	private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		Connection conn = getDBConnection();
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body bgcolor='lightred'>");
		writer.write("<form method='get' action='/DepartmentsJDBC/deptDetails'>");
		writer.write("Dept Id : <input type='text' name='deptId' id='deptId'></input>");
		writer.write("<input type='submit' value='Get Dept Detail'/>");
		writer.write("</form>");
		writer.write("</body></html>");
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
