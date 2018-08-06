package com.jdbcexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BottomTenEmployees {

	public static void main(String[] args) {
		Connection conn =null;
		Statement stmt =null;
		ResultSet rs = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn =DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
			stmt =conn.createStatement();
			rs =stmt.executeQuery("select rownum, first_name, salary from (select first_name, salary from employees order by salary) where rownum <=10");
			while(rs.next()){
				System.out.println("S.No :"+rs.getInt(1)+" ||First_name :"+rs.getString(2)+" ||Salary :"+rs.getDouble(3));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		}

	}

}
