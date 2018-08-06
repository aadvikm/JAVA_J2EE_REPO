import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCLesson9 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement prepStatement= null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        con.setAutoCommit(false);
	        prepStatement = con.prepareStatement("INSERT INTO DEPARTMENTS(DEPARTMENT_ID, DEPARTMENT_NAME, LOCATION_ID) VALUES(?, ?,?)");
	        int count = 0;
	        while(count < 3){
	        	int pk = 2000+count;
	        	prepStatement.setInt(1, pk );
	 	        prepStatement.setString(2, "DeptA" );
	 	        prepStatement.setInt(3, 1700);
	 	        prepStatement.addBatch();
	 	        count++;
	        }
	        int[] result = prepStatement.executeBatch();
            for(int i : result){
            	System.out.println("Result : "+i);
            }
	        System.out.println("Completed!!!");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
				if(con != null)
					con.close();
			}
			catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			
		}

	}

}
