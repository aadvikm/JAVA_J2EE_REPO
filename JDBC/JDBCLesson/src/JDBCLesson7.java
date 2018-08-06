
public class JDBCLesson7 {

	public static void main(String[] args) {
		DepartmentDao deptDao = new DepartmentDaoImpl();
		
		//DepartmentEntity deptEntity = new DepartmentEntity();
		//deptEntity.setDeptId(800);
		//deptEntity.setDeptName("Training");
		//deptEntity.setLocationId(1700);
		
		//deptDao.saveDepartment(deptEntity);
		
		//DepartmentEntity deptEntity1 = null;
		//deptEntity1 = deptDao.fetchDepartment(380);
		
		//System.out.println("Fetched Value : "+deptEntity1);
		
		/*DepartmentEntity deptEntity = new DepartmentEntity();
		deptEntity.setDeptId(800);
		deptEntity.setDeptName("Quality");
		deptEntity.setLocationId(1700);
		deptDao.updateDepartment(deptEntity);*/
		
		//deptDao.deleteDepartment(800);
		
		DepartmentEntity deptEntity1 = null;
		deptEntity1 = deptDao.fetchDepartment(380);
		System.out.println("Before Value : "+deptEntity1);
		deptEntity1.setDeptName(deptEntity1.getDeptName()+" Hi");
		System.out.println("After Value : "+deptEntity1);
		deptDao.updateDepartment(deptEntity1);
		

	}

}
