package com.jdbcexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class RedultSetMetaData {

	public static void main(String[] args) {
		Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select Department_id, Department_name from Departments");
            rsmd = rs.getMetaData();
            System.out.println("Column Count :"+rsmd.getColumnCount());
            System.out.println("Column Name :"+rsmd.getColumnName(2));
            System.out.println("Column Type Name :"+rsmd.getColumnTypeName(1));
            System.out.println("Table Name :"+rsmd.getTableName(2));
        }
        catch(SQLException se){
        	se.printStackTrace();
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
        finally{
        	try{
        		if(con!=null && stmt!=null &&rs!=null){
        			rs.close();
        			stmt.close();
        			con.close();
        		}
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}
        }


	}

}
