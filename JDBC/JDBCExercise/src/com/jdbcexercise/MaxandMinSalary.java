package com.jdbcexercise;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class MaxandMinSalary {

	public static void main(String[] args) {
		Connection con =null;
		CallableStatement callstmt =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        callstmt=con.prepareCall("{call PR_DEPT_MAX_MIN_SAL(?,?,?)}");
	        callstmt.setInt(1, 80);
	        callstmt.registerOutParameter(2, Types.DOUBLE);
	        callstmt.registerOutParameter(3, Types.DOUBLE);
	        callstmt.execute();
	        Double Max_sal = callstmt.getDouble(2);
	        Double Min_sal = callstmt.getDouble(3);
	        System.out.println("Max_sal :"+Max_sal+" ||Min_sal :"+Min_sal);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}

	}

}
