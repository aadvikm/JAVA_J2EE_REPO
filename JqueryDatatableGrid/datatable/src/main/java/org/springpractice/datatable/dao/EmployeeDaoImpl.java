package org.springpractice.datatable.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springpractice.datatable.domain.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	private static Logger LOG = Logger.getLogger(EmployeeDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ArrayList<Employee> getManagers() throws Exception {
		LOG.info("Fetching Mgr List");
		Session session = sessionFactory.openSession();
		SQLQuery query1 =session.createSQLQuery("SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE, SALARY, D.DEPARTMENT_NAME, L.CITY FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND L.LOCATION_ID = D.LOCATION_ID AND EXISTS (SELECT * FROM EMPLOYEES E1 WHERE E1.MANAGER_ID = E.EMPLOYEE_ID)");
		ArrayList<Employee> empList =new ArrayList<Employee>();
		for(Object obj : query1.list()){
			Object[] objArr = (Object[]) obj;
			Employee emp =new Employee();
			emp.setEmployeeId(((BigDecimal)objArr[0]).longValue());
			emp.setFirstName((String)objArr[1]);
			empList.add(emp);
		}
		session.close();
		LOG.info("Returning mgr list...");
		return empList;
	}

	public ArrayList<Employee> getEmployees(Long mgrId) throws Exception {
		LOG.info("Fetching Mgr's employee List");
		Session session = sessionFactory.openSession();
		SQLQuery query1 =session.createSQLQuery("SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE, SALARY, D.DEPARTMENT_NAME, L.CITY FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND L.LOCATION_ID = D.LOCATION_ID AND E.MANAGER_ID ="+mgrId);
		ArrayList<Employee> empList =new ArrayList<Employee>();
		for(Object obj : query1.list()){
			Object[] objArr = (Object[]) obj;
			Employee emp =new Employee();
			emp.setEmployeeId(((BigDecimal)objArr[0]).longValue());
			emp.setFirstName((String)objArr[1]);
			emp.setLastName((String)objArr[2]);
			emp.setHireDate((Date)objArr[3]);
			emp.setSalary((BigDecimal)objArr[4]);
			emp.setDepartment((String)objArr[5]);
			emp.setLocation((String)objArr[6]);
			empList.add(emp);
		}
		session.close();
		LOG.info("Returning mgr's employee list...");
		return empList;
	}


}
