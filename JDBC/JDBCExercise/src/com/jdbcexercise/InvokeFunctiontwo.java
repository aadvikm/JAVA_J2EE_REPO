package com.jdbcexercise;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
public class InvokeFunctiontwo {

	public static void main(String[] args) {
		Connection conn =null;
		CallableStatement callStmt =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        conn = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        callStmt =conn.prepareCall("{?=call FN_DEPT_SAL(?,?,?)}");
	        callStmt.registerOutParameter(1, Types.INTEGER);
			callStmt.setInt(2, 50);
			callStmt.setInt(3, 1000);
			callStmt.setInt(4, 5000);
			callStmt.execute();
			Integer count =callStmt.getInt(1);
			System.out.println("Emp Count :"+count);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			 try{
				 if(callStmt!=null)
					 callStmt.close();
				 if(conn !=null)
					 conn.close();
			 }
			 catch(Exception e){
				 e.printStackTrace();
				 
			 }
			}

	}

}
