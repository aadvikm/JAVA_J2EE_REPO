import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public void saveDepartment(DepartmentEntity deptEntity) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String insertStatement = "insert into departments (department_id, department_name, manager_id, location_id) values  ("
					+ deptEntity.getDeptId() + ", '" + deptEntity.getDeptName() + "' , " + deptEntity.getManagerId() + ", "
					+ deptEntity.getLocationId() + ")";
			System.out.println("Execution.. : "+insertStatement);
			stmt.execute(insertStatement);
			conn.commit();
			System.out.println("Inserted Successfully!!!!");
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

	@Override
	public DepartmentEntity fetchDepartment(int deptId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
			stmt = conn.createStatement();
			String fetchQuery = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID ="+deptId;
			System.out.println("Execution.. : "+fetchQuery);
			rs = stmt.executeQuery(fetchQuery);
			rs.next();
			
			DepartmentEntity deptEnity = new DepartmentEntity();
			deptEnity.setDeptId(deptId);
			deptEnity.setDeptName(rs.getString(2));
			deptEnity.setManagerId(rs.getInt(3) == 0 ? null : rs.getInt(3));
			deptEnity.setLocationId(rs.getInt(4));
			System.out.println("Fetched Successfully!!!!");
			return deptEnity;
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
		return null;
	}

	@Override
	public void updateDepartment(DepartmentEntity deptEntity) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
			stmt = conn.createStatement();
			String updateStatement = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = '"+deptEntity.getDeptName()+"', LOCATION_ID = "+deptEntity.getLocationId()+", MANAGER_ID = "+deptEntity.getManagerId()+" WHERE DEPARTMENT_ID = "+deptEntity.getDeptId();
			System.out.println("Execution.. : "+updateStatement);
			stmt.executeUpdate(updateStatement);
			System.out.println("Updated Successfully!!!!");
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

	@Override
	public void deleteDepartment(int deptId) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost");
			stmt = conn.createStatement();
			String deleteStatement = " DELETE DEPARTMENTS WHERE DEPARTMENT_ID = "+deptId;
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
