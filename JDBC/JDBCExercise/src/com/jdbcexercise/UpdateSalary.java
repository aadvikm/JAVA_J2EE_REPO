package com.jdbcexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSalary {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement prestmt =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        con.setAutoCommit(false);
	        prestmt = con.prepareStatement("update employees set salary = salary +((salary*10)/100) where department_id =10");
	        prestmt.execute();
	        int count = prestmt.executeUpdate();
	        System.out.println("No of Rows updated :"+count);
	       
	        con.rollback();
	        System.out.println("Rollbacked..!!");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
				if(con !=null && prestmt !=null){
					prestmt.close();
					con.close();
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}

	}

}
