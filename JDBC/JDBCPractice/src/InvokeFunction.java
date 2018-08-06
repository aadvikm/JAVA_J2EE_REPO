import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

//4) Write a program to invoke and print the result of any funtion that you've already created in PLSQL.
public class InvokeFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con =null;
		CallableStatement callstmt =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        callstmt = con.prepareCall("{?=call FN_COUNT_PRE_JOB(?)}");
	        callstmt.registerOutParameter(1, Types.INTEGER);
	        callstmt.setInt(2, 102);
	        callstmt.execute();
	        Integer count =callstmt.getInt(1);
	        System.out.println("Count of employee's previous Job :"+count);
	        
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
