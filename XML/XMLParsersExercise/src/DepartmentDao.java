
public interface DepartmentDao {
	
	public void saveDepartment(DepartmentEntity deptEntity);
	
	public DepartmentEntity fetchDepartment(int deptId);
	
	public void updateDepartment(DepartmentEntity deptEntity);
	
	public void deleteDepartment(int deptId);

}
