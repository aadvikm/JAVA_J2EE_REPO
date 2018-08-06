import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JDBCLesson4 {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement callStmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        callStmt = con.prepareCall("{call PR_EMP_CITY(?,?) }");
	        callStmt.setString(1, "Seattle");
	        callStmt.registerOutParameter(2, Types.INTEGER);
	        callStmt.execute();
	        Integer count = callStmt.getInt(2);
	        System.out.println("Employee count : "+count);
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
