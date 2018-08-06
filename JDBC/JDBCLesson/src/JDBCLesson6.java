import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCLesson6 {

	public static void main(String[] args) {
		Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT FIRST_NAME, MANAGER_ID as MGR_Id FROM EMPLOYEES");
            rsmd = rs.getMetaData();
            System.out.println("Column Count : "+rsmd.getColumnCount());
            System.out.println(rsmd.getColumnTypeName(1) + " " + rsmd.getColumnTypeName(2));
            System.out.println(rsmd.getColumnName(1) + " " + rsmd.getColumnName(2));
            while(rs.next()) {
                System.out.println(rs.getString(1) + " "+ rs.getString(2));
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(rs != null && stmt != null && con != null){
            		rs.close();
                    stmt.close();
                    con.close();
            	}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

	}

}
