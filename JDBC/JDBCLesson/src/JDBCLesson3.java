import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCLesson3 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement prepStatement= null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        con.setAutoCommit(false);
	        prepStatement = con.prepareStatement("INSERT INTO DEPARTMENTS(DEPARTMENT_ID, DEPARTMENT_NAME, LOCATION_ID) VALUES(?, ?,?)");
	        stmt = con.createStatement();
	        rs = stmt.executeQuery("select DEPARTMENTS_SEQ.NEXTVAL from dual");
	        if(rs.next());
	        prepStatement.setInt(1, rs.getInt(1) );
	        prepStatement.setString(2, "DeptA" );
	        prepStatement.setInt(3, 1700);
	        prepStatement.execute();
	        System.out.println("Inserted!!!");
	        rs = stmt.executeQuery("select DEPARTMENTS_SEQ.NEXTVAL from dual");
	        if(rs.next());
	        prepStatement.setInt(1, rs.getInt(1) );
	        prepStatement.setString(2, "DeptB" );
	        prepStatement.setInt(3, 1700);
	        prepStatement.execute();
	        System.out.println("Inserted!!!");
	        rs = stmt.executeQuery("select DEPARTMENTS_SEQ.NEXTVAL from dual");
	        if(rs.next());
	        prepStatement.setInt(1, rs.getInt(1) );
	        prepStatement.setString(2, "DeptC" );
	        prepStatement.setInt(3, 1700);
	        prepStatement.execute();
	        System.out.println("Inserted!!!");
	        //con.commit();
	        //System.out.println("Committed!!!");
	        //con.rollback();
	        //System.out.println("Rollbacked!!!");
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
