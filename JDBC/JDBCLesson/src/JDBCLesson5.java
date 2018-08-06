import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JDBCLesson5 {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement callStmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        callStmt = con.prepareCall("{? = call FN_GET_MAX_SAL(?) }");
	        callStmt.registerOutParameter(1, Types.DOUBLE);
	        callStmt.setString(2, "10");
	        callStmt.execute();
	        Double maxSal = callStmt.getDouble(1);
	        System.out.println("Max Salary : "+maxSal);
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally{
			if(con != null){
				try{
					con.close();
				}
				catch(SQLException sqlException){
					sqlException.printStackTrace();
				}
				
			}
		}

	}

}
