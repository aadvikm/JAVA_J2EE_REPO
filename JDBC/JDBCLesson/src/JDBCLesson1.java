import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCLesson1 {
	
	public static void main(String[] args){
		 	Connection con = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	            stmt = con.createStatement();
	            rs = stmt.executeQuery("SELECT FIRST_NAME, MANAGER_ID FROM EMPLOYEES");
	            while(rs.next()) {
	                System.out.println(rs.getString(1) + " "+ rs.getString(2));
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                rs.close();
	                stmt.close();
	                con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}

}
