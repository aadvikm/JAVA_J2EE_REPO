package com.apache.webservice.tutorial.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.apache.webservice.tutorial.domain.Department;
import com.apache.webservice.tutorial.domain.EmployeeDetail;
import com.apache.webservice.tutorial.domain.EmployeeEntity;
import com.apache.webservice.tutorial.domain.Manager;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private static Logger LOG = Logger.getLogger(EmployeeDaoImpl.class);
	private SessionFactory sessionFactory;

	public EmployeeDaoImpl() {
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public EmployeeEntity getEmployeeEntity(Long empId) throws Exception {
		LOG.info("Fetching Employee Entity......");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		EmployeeEntity employeeEntity = (EmployeeEntity) session.get(EmployeeEntity.class, empId);
		tx.commit();
		session.close();
		return employeeEntity;
	}

	public EmployeeEntity saveEmployeeEntity(EmployeeEntity employeeEntity) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(employeeEntity);
		tx.commit();
		session.close();
		LOG.info("Employee Entity is saved successfully!!!");
		return employeeEntity;
	}

	public EmployeeEntity updateEmployeeEntity(EmployeeEntity employeeEntity) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(employeeEntity);
		tx.commit();
		session.close();
		LOG.info("Employee Entity is updated successfully!!!");
		return employeeEntity;
	}

	public void deleteEmployeeEntity(EmployeeEntity employeeEntity) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(employeeEntity);
		tx.commit();
		LOG.info("Employee Entity is deleted successfully!!!");
		session.close();
	}

	public EmployeeDetail getEmpDetail(Long empId) throws Exception {
		LOG.info("Fetching employee detail for emp id : " + empId);
		Session session = sessionFactory.openSession();
		EmployeeDetail employeeDetail = new EmployeeDetail();
		employeeDetail.setEmpId(empId);
		Query query = session.createSQLQuery(
				"Select e.first_name as firstName, e.last_name as lastName, e.manager_id as managerId, e.salary as salary, e.hire_date as hireDate, d.department_id as deptId from employees e, departments d  where e.department_id =d.department_id  and e.employee_id ="
						+ empId);
		for (Object obj : query.list()) {
			Object[] objArr = (Object[]) obj;
			employeeDetail.setFirstName((String) objArr[0]);
			employeeDetail.setLastName((String) objArr[1]);
			employeeDetail.setManagerId(Long.valueOf(((BigDecimal) objArr[2]).longValue()));
			employeeDetail.setSalary((BigDecimal) objArr[3]);
			Date hdate = (Date) objArr[4];
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			employeeDetail.setHireDate(sdf.format(hdate));
			employeeDetail.setDeptId(Long.valueOf(((BigDecimal) objArr[5]).longValue()));
		}
		session.close();
		LOG.info("Returning Employee Detail list...");
		return employeeDetail;
	}

	public List<Manager> getManagerList() throws Exception {
		LOG.info("Fetching Manager List");
		Session session = sessionFactory.openSession();
		ArrayList<Manager> managerList = new ArrayList();
		SQLQuery query1 = session.createSQLQuery(
				"Select employee_id as mgrId, (first_name||' '||last_name) as mgrName from employees e where employee_id in(select manager_id from employees)");
		for (Object obj : query1.list()) {
			Object[] objArr = (Object[]) obj;
			Manager mgr = new Manager(Long.valueOf(((BigDecimal) objArr[0]).longValue()), (String) objArr[1]);
			managerList.add(mgr);
		}
		session.close();
		LOG.info("Returning Manager list...");
		return managerList;
	}

	public List<Department> getDeptList() throws Exception {
		LOG.info("Fetching Department List");
		Session session = sessionFactory.openSession();
		SQLQuery query2 = session
				.createSQLQuery("Select Department_id as deptId, department_name as deptName from Departments");
		ArrayList<Department> deptList = new ArrayList();
		for (Object obj : query2.list()) {
			Object[] objArr = (Object[]) obj;
			Department loc = new Department(Long.valueOf(((BigDecimal) objArr[0]).longValue()), (String) objArr[1]);
			deptList.add(loc);
		}
		session.close();
		LOG.info("Returning Department list...");
		return deptList;
	}

	public List<EmployeeDetail> getEmployees() throws Exception {
		LOG.info("Fetching Employees");
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("Select employee_id as empId, first_name as firstName from employees");
		ArrayList<EmployeeDetail> empList = new ArrayList();

		for (Object obj : query.list()) {
			Object[] objArr = (Object[]) obj;
			EmployeeDetail emp = new EmployeeDetail(Long.valueOf(((BigDecimal) objArr[0]).longValue()),
					(String) objArr[1]);
			empList.add(emp);
		}
		session.close();
		LOG.info("Returning Employee list...");
		return empList;
	}
}