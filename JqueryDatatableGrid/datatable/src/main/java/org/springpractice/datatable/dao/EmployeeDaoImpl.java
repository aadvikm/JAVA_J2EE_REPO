package org.springpractice.datatable.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

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
		ArrayList<Employee> mgrList =new ArrayList<Employee>();
		for(Object obj : query1.list()){
			Object[] objArr = (Object[]) obj;
			Employee emp =new Employee(, (String)objArr[1]);
			emp.setEmployeeId(((BigDecimal)objArr[0]).longValue());
			mgrList.add(mgr);
		}
		session.close();
		LOG.info("Returning mgr list...");
		return mgrList;
	}

	public ArrayList<Employee> getEmployees() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
