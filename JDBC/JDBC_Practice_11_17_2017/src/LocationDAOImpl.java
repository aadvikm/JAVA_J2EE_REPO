import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LocationDAOImpl implements LocationDAO {

	@Override
	public void saveLocation(LocationEntity locEntity) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String insertStatement = "insert into Locations values(" + locEntity.getLocId() + ",'"
					+ locEntity.getStreetAdd() + "','" + locEntity.getPostalCode() + "','" + locEntity.getCity() + "','"
					+ locEntity.getStateProvince() + "','" + locEntity.getCountryId() + "')";
			System.out.println("Execution.. : "+insertStatement);
			stmt.execute(insertStatement);
			System.out.println("Inserted Sucessfully!!!");
		
		} catch (Exception ex) {
			try{
				conn.rollback();
			}
			catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			ex.printStackTrace();
		}
		finally{
			try{
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		}
	}

	@Override
	public LocationEntity fetchLocation(int locId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
			stmt = conn.createStatement();
			String fetchQuery = "select Location_id, Street_Address, Postal_Code, City, State_Province, Country_id from Locations where location_id ="
					+ locId;
			System.out.println("Execution.. : " + fetchQuery);
			rs = stmt.executeQuery(fetchQuery);
			rs.next();
			
			LocationEntity locEntity =new LocationEntity();
			locEntity.setLocId(locId);
			locEntity.setStreetAdd(rs.getString(2));
			locEntity.setPostalCode(rs.getString(3));
			locEntity.setCity(rs.getString(4));
			locEntity.setStateProvince(rs.getString(5));
			locEntity.setCountryId(rs.getString(6));
			System.out.println("Fetched Successfully!!!!");
			return locEntity;
			
		}
		catch(Exception e){
			try{
				conn.rollback();
			}
			catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try{
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void updateLocation(LocationEntity locEntity) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
			stmt = conn.createStatement();
			String updateStatement = "update Locations set Location_id =" + locEntity.getLocId() + ", Street_Address ='"
					+ locEntity.getStreetAdd() + "', Postal_Code ='" + locEntity.getPostalCode() + "', City ='"
					+ locEntity.getCity() + "', State_Province ='" + locEntity.getStateProvince() + "', Country_Id='"
					+ locEntity.getCountryId() + "'where Location_id =" + locEntity.getLocId();
			System.out.println("Execution.. : "+updateStatement);
			stmt.executeUpdate(updateStatement);
			System.out.println("Updated Successfully!!!!");
		}
		catch(Exception e){
			try{
				conn.rollback();
			}
			catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try{
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		}

	}

	@Override
	public void deleteLocation(int locId) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
			stmt = conn.createStatement();
			String deleteStatement = "Delete Locations where Location_id ="+locId;
			System.out.println("Execution.. : "+deleteStatement);
			stmt.executeUpdate(deleteStatement);
			System.out.println("Deleted Successfully!!!!");
		}
		catch(Exception exception){
			try{
				conn.rollback();
			}
			catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			exception.printStackTrace();
		}
		finally{
			try{
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		}

	}

}
