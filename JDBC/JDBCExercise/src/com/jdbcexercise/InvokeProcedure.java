package com.jdbcexercise;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class InvokeProcedure {

	public static void main(String[] args) {
		Connection conn =null;
		CallableStatement callStmt =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn =DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
			callStmt =conn.prepareCall("call pk_dept_sal.pr_dept_sal(?,?,?,?)");
			callStmt.registerOutParameter(4, Types.INTEGER);
			callStmt.setInt(1, 50);
			callStmt.setInt(2, 1000);
			callStmt.setInt(3, 5000);
			callStmt.execute();
			 Integer count =callStmt.getInt(4);
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
