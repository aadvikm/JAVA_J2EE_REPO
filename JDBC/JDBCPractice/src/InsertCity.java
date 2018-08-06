import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//5) Insert a record in city table using prepared statement.
public class InsertCity {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement prestmt =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
	        con.setAutoCommit(false);
	        prestmt = con.prepareStatement("insert into Locations(Location_id, city, postal_code) values(?,?,?)");
	        int count = 0;
	        while(count < 2){
	        	int locId = 6000+count;
		        prestmt.setInt(1, locId);
		        prestmt.setString(2, "Chennai");
		        prestmt.setString(3, "600063");
		        System.out.println("Inserted..!!");
		        prestmt.addBatch();	
		        count++;
	       }
	        int[] result = prestmt.executeBatch();
            for(int i : result){
            	System.out.println("Result : "+i);
            }
	        System.out.println("Completed!!!");
		}
		catch(Exception ex){
			try{
				con.rollback();
			}
			catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
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
