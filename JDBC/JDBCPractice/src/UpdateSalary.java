import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//5) Write a program that increases salary of dept id 10 employees by 10%. You need to write update statment in JDBC Statement.
public class UpdateSalary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement prestmt =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        con.setAutoCommit(false);
	        prestmt = con.prepareStatement("update employees set salary = salary +((salary*10)/100) where department_id =10");
	        prestmt.execute();
	        int count = prestmt.executeUpdate();//returns no of rows updated..
	        System.out.println("No of Rows updated :"+count);
	       // con.commit();
	      //  System.out.println("Committed!!!");
	        con.rollback();
	        System.out.println("Rollbacked..!!");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
				if(con !=null && prestmt !=null){
					prestmt.close();
					con.close();
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
	}

}
