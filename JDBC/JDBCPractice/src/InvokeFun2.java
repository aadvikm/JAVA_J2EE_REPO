import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/*3) Write a java program to invoke a function that take more than one parameter and return a value.
(Eg. Function that takes dept id and salary range (1000 and 5000), return no of employees in the sal range)*/
public class InvokeFun2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
