import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//2) Write a program that fetches top three earning employee and print the same. Using ResultSet, print them in decending order too.
public class TopThreeEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con =null;
		Statement stmt =null;
		ResultSet rs =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from (select Rownum as rank, first_name, salary from employees order by salary desc) where rank<=3");
            System.out.println("Ascending Order..!");
            while(rs.next()){
            	System.out.println(rs.getInt(1) + " ||First_Name :"+ rs.getString(2)+" ||Salary :"+rs.getDouble(3));
            }
            
        	System.out.println("Decending Order..!");
            while(rs.previous()){
                        	System.out.println(rs.getInt(1) + " ||First_Name :"+ rs.getString(2)+" ||Salary :"+rs.getDouble(3));
            }
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			 try{
				 if(con !=null && stmt !=null && rs !=null){
					 rs.close();
					 stmt.close();
					 con.close();
				 }
			 }
			 catch(Exception ex){
				 ex.printStackTrace();
			 }
			}
	}
}
