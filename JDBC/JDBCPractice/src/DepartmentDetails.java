import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//1) Write a program to print all the department details.
public class DepartmentDetails {
	public static void main(String[]args){
		Connection con =null;
		Statement stmt =null;
		ResultSet rs =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM DEPARTMENTS");
            while(rs.next()){
            	System.out.println("Dept_Id :"+rs.getInt(1) + " ||Dept_Name :"+ rs.getString(2)+" ||MGR_ID :"+rs.getInt(3)+" ||Loc_Id : "+rs.getInt(4));
            }
		}
		catch(Exception e){
		 e.printStackTrace();
		}
		finally{
		 try{
			 if(con !=null && stmt !=null && rs !=null){
				 con.close();
				 stmt.close();
				 rs.close();
			 }
		 }
		 catch(Exception ex){
			 ex.printStackTrace();
		 }
		}
	}

}
