import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCLesson2 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement prepStatement= null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        prepStatement = con.prepareStatement("INSERT INTO DEPARTMENTS(DEPARTMENT_ID, DEPARTMENT_NAME, LOCATION_ID) VALUES(?, ?,?)");
	        prepStatement.setInt(1, 900 );
	        prepStatement.setString(2, "DeptA" );
	        prepStatement.setInt(3, 1700);
	        prepStatement.execute();
	        System.out.println("Inserted!!!");
	        prepStatement.setInt(1, 901 );
	        prepStatement.setString(2, "DeptB" );
	        prepStatement.setInt(3, 1700);
	        prepStatement.execute();
	        System.out.println("Inserted!!!");
	        prepStatement.setInt(1, 902 );
	        prepStatement.setString(2, "DeptC" );
	        prepStatement.setInt(3, 1700);
	        prepStatement.execute();
	        System.out.println("Inserted!!!");
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
