package org.springpractice.dao;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springpractice.domain.DepartmentDetail;
import org.springpractice.domain.DepartmentEntity;
import org.springpractice.domain.Employee;
import org.springpractice.domain.Location;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	private static Logger LOG = Logger.getLogger(DepartmentDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public DepartmentEntity getDepartmentEntity(Long deptId) throws Exception {
		LOG.info("Fetching Department Entity......");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		DepartmentEntity departmentEntity = (DepartmentEntity) session.get(DepartmentEntity.class, deptId);
		tx.commit();
		session.close();
		return departmentEntity;
	}

	public DepartmentEntity saveDepartmentEntity(DepartmentEntity departmentEntity) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(departmentEntity);
		tx.commit();
		session.close();
		LOG.info("Department Entity is saved successfully!!!");
		return departmentEntity;
	}

	public DepartmentEntity updateDepartmentEntity(DepartmentEntity departmentEntity) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(departmentEntity);
		tx.commit();
		session.close();
		LOG.info("Department Entity is updated successfully!!!");
		return departmentEntity;
	}

	public void deleteDepartmentEntity(DepartmentEntity departmentEntity) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(departmentEntity);
		tx.commit();
		LOG.info("Department Entity is deleted successfully!!!");
		session.close();
	}

	public List<Employee> getManagerList() throws Exception {
		LOG.info("Fetching Mgr List");
		Session session = sessionFactory.openSession();
		SQLQuery query1 = session.createSQLQuery(
				"Select employee_id as mgrId, (first_name||' '||last_name) as mgrName from employees e where employee_id in(select manager_id from employees)");
		ArrayList<Employee> mgrList = new ArrayList();
		for (Object obj : query1.list()) {
			Object[] objArr = (Object[]) obj;
			Employee mgr = new Employee(Long.valueOf(((BigDecimal) objArr[0]).longValue()), (String) objArr[1]);
			mgrList.add(mgr);
		}
		session.close();
		LOG.info("Returning mgr list...");
		return mgrList;
	}

	public List<Location> getLocationList() throws Exception {
		LOG.info("Fetching Location List");
		Session session = sessionFactory.openSession();
		SQLQuery query2 = session.createSQLQuery("Select location_id as locId, city as city from locations");
		ArrayList<Location> locList = new ArrayList();
		for (Object obj : query2.list()) {
			Object[] objArr = (Object[]) obj;
			Location loc = new Location(Long.valueOf(((BigDecimal) objArr[0]).longValue()), (String) objArr[1]);
			locList.add(loc);
		}
		session.close();
		LOG.info("Returning Location list...");
		return locList;
	}

	public List<DepartmentDetail> getDepartments() throws Exception {
		LOG.info("Fetching departments");
		Session session = sessionFactory.openSession();
		SQLQuery query = session
				.createSQLQuery("Select Department_id as deptId, Department_name as deptName from Departments");

		ArrayList<DepartmentDetail> deptList = new ArrayList();

		for (Object obj : query.list()) {
			Object[] objArr = (Object[]) obj;
			DepartmentDetail dept = new DepartmentDetail(Long.valueOf(((BigDecimal) objArr[0]).longValue()),
					(String) objArr[1]);
			deptList.add(dept);
		}
		session.close();
		LOG.info("Returning Departments list...");
		return deptList;
	}

	public DepartmentDetail getDeptDetail(Long deptId) throws Exception {
		LOG.info("Fetching department detail for dept id : " + deptId);
		Session session = sessionFactory.openSession();
		DepartmentDetail deptDetail = new DepartmentDetail();
		deptDetail.setDeptId(deptId);
		Query query = session.createSQLQuery(
				"Select department_name as deptName, manager_id as mgrId, location_id as locId from departments where department_id ="
						+ deptId);
		for (Object obj : query.list()) {
			Object[] objArr = (Object[]) obj;
			deptDetail.setDeptName((String) objArr[0]);
			deptDetail.setMgrId(Long.valueOf(((BigDecimal) objArr[1]).longValue()));
			deptDetail.setLocId(Long.valueOf(((BigDecimal) objArr[2]).longValue()));
		}
		session.close();
		LOG.info("Returning Department Detail list...");
		return deptDetail;
	}
}
