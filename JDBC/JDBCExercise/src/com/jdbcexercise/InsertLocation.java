package com.jdbcexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertLocation {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement prestmt =null;
		Statement stmt =null;
		ResultSet rs =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        con.setAutoCommit(false);
	        prestmt = con.prepareStatement("insert into Locations(Location_id, city, postal_code) values(?,?,?)");
	        stmt =con.createStatement();
	        rs=stmt.executeQuery("select Locations_seq.nextval from dual");
	        if(rs.next());
	        prestmt.setInt(1, rs.getInt(1));
	        prestmt.setString(2, "Chennai");
	        prestmt.setString(3, "600063");
	        prestmt.execute();
	        System.out.println("Inserted..!!");
	        rs=stmt.executeQuery("select Locations_seq.nextval from dual");
	        if(rs.next());
	        prestmt.setInt(1, rs.getInt(1));
	        prestmt.setString(2, "Delhi");
	        prestmt.setString(3, "600001");
	        prestmt.execute();
	        System.out.println("Inserted..!!");
		  con.rollback();
		   System.out.println("Rollbacked..!!");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
				if(con !=null && prestmt !=null && stmt!=null && rs!=null){
					rs.close();
					stmt.close();
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
