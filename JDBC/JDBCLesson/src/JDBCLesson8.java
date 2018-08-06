import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCLesson8 {
	
	public static void main(String[] args){
		Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
            stmt = con.createStatement();
            
            //batch example
            stmt.addBatch("UPDATE EMPLOYEES SET SALARY = SALARY+1 WHERE DEPARTMENT_ID = 10");
            stmt.addBatch("INSERT INTO DEPARTMENTS VALUES (1000, 'TEST', NULL, 1700)");
            
            int[] result = stmt.executeBatch();
            for(int i : result){
            	System.out.println("Result : "+i);
            }
            //without batch
            int count = 0;
            while(count < 2){
            	int deptPK = 901+count;
            	stmt.executeQuery("INSERT INTO DEPARTMENTS VALUES ("+deptPK+", 'TEST', NULL, 1700)");
            	count++;
            }
            System.out.println("Completed!!!");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

}
