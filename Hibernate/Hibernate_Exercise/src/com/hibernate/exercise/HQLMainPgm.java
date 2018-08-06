package com.hibernate.exercise;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


/* 1) Write a HQL to fetch employee who do not have managers. 
2) Write a HQL that give the count of employee for a department. Pass department name as parameter. (Note: if there is any relationship. Please disable it.)
3) Write a HQL that gives employees from passed location.
4) Write a HQL to get average salary of passed dept id. 
5) Write a HQL to get list of employees who earn more than their managers. 
6) Write a HQL to get employee list with hire date decending order.
7) Write a HQL to returns following details FirstName, LastName, ManagerFirstName, ManagerLastName, EmpDepartmentName, City. 
8) Take above query transform the result to map and print the details. 
9) Write a Named HQL query to fetch only managers. 
10) Write a Named HQL query to getch EmpFirstName, EmpLastName, Salary for the passed department id.*/

public class HQLMainPgm {

	public static void main(String[] args) {
		try{
			//creating configuration object  
		    Configuration cfg=new AnnotationConfiguration();  
		    //populates the data of the configuration file
		    cfg.configure("hibernate.cfg.xml");   
		    //creating session factory object  
		    SessionFactory factory=cfg.buildSessionFactory();  
		    //creating session object  
		    Session session=factory.openSession();
		    
		    //1) Write a HQL to fetch employee who do not have managers. 
		    Query q =session.createQuery("select e from EmployeeEntity e where e.managerId is null");
		    List<EmployeeEntity> empList=q.list();
		    for(EmployeeEntity e :empList){
		    	//System.out.println(e);
		    }
			
		    //2) Write a HQL that give the count of employee for a department. Pass department name as parameter.
		    //(Note: if there is any relationship. Please disable it.)
		    Query q1 =session.createQuery("select count(e.employeeId) as EmpCount from EmployeeEntity e, DepartmentEntity d where e.departmentId=d.deptId and d.deptName =:deptName ");
		    q1.setParameter("deptName", new String("Shipping"));
		    q1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		    List<Map> resultSet=q1.list();
		    for(Map m :resultSet){
		    	//System.out.println("Emp_count :"+ m.get("EmpCount"));
		    }
		    
		    //3) Write a HQL that gives employees from passed location.
		    Query q3=session.createQuery("select e.employeeId as EmpId, e.firstName as FirstName, d.deptName as DeptName from EmployeeEntity e, DepartmentEntity d where e.departmentId =d.deptId and d.locationId =:locId");
		    q3.setParameter("locId", 2400);
		    q3.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		    List<Map> resultSet1 =q3.list();
		    for(Map m1 :resultSet1){
		    	//System.out.println(m1.get("EmpId") +" : "+ m1.get("FirstName") +" : "+m1.get("DeptName"));
		    }
		
		    //4) Write a HQL to get average salary of passed dept id. 
		    Query q4=session.createQuery("select AVG(e.salary) as AVGSAL from EmployeeEntity e where departmentId =:departId");
		    q4.setParameter("departId", 50L);
		    q4.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		    List<Map> resultSet2 = q4.list();
		    for(Map row : resultSet2){
		    	//System.out.println("AvgSAL :"+row.get("AVGSAL"));
		    }
		    
		    
		    //5) Write a HQL to get list of employees who earn more than their managers.
		    Query q5=session.createQuery("select e from EmployeeEntity e, EmployeeEntity m where e.managerId =m.employeeId and e.salary >m.salary");
		    List<EmployeeEntity> empList3 =q5.list();
		    for(EmployeeEntity e3 : empList3){
		    	//System.out.println(e3);
		    }
		    
		    //6) Write a HQL to get employee list with hire date decending order.
		    Query q6=session.createQuery("select e from EmployeeEntity e order by e.hireDate desc");
		    List<EmployeeEntity> empList4 =q6.list();
		    for(EmployeeEntity e4 : empList4){
		    	//System.out.println(e4);
		    }
		    
		    //7) Write a HQL to returns following details FirstName, LastName, ManagerFirstName, ManagerLastName, 
		    //EmpDepartmentName, City. 
		    //8) Take above query transform the result to map and print the details. 
		    
		    Query q7 =session.createQuery("select e.firstName as FirstName, e.lastName as LastName, m.firstName as MgrFirstName, m.lastName as MgrLastName, d.deptName as DeptName, l.city as City from EmployeeEntity e, EmployeeEntity m, DepartmentEntity d, LocationEntity l where e.managerId =m.employeeId and e.departmentId =d.deptId and d.locationId =l.locId");
		    q7.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		    List<Map> resultSet3 = q7.list();
		    for(Map m5 : resultSet3){
		    	//System.out.println("Emp_FirstName :"+ m5.get("FirstName") +" ||Emp_LastName :"+ m5.get("LastName")+ " ||Mgr_firstName :"+ m5.get("MgrFirstName") + " ||Mgr_LastName : "+ m5.get("MgrLastName") + " ||DeptName :"+m5.get("DeptName") +" ||City :"+ m5.get("City"));
		    }
		    
		    //9) Write a Named HQL query to fetch only managers. 
		    Query q9 =session.getNamedQuery("gtOnlyManagers");
		    List<EmployeeEntity> resultSet4 = q9.list();
		    for(EmployeeEntity m6 :resultSet4){
		    	//System.out.println(m6);
		    }
		    
		    
		    //10) Write a Named HQL query to getch EmpFirstName, EmpLastName, Salary for the passed department id.
		    Query q10 =session.getNamedQuery("gtEmpDetailDeptId");
		    q10.setParameter("departId", 20L);
		    q10.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		    List<Map> resultSet5 = q10.list();
		    for(Map m7 : resultSet5){
		    	System.out.println("Emp_First_name :" +m7.get("FirstName") +" ||LastName :"+ m7.get("LastName")+" ||Salary :"+m7.get("Salary"));
		    }
		    
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			System.out.println("Finally Block..!!");
		}

	}

}
