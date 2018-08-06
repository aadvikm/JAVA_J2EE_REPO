import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

//2) Write a program to invoke a procedure inside a package that takes one or more param as input and returns a value. 
public class InvokeProce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
