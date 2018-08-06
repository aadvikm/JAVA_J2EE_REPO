package com.hibernatepractice;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HQLMainProgram {

	public HQLMainProgram() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			
			Configuration cfg=new AnnotationConfiguration();  
		    //populates the data of the configuration file
		    cfg.configure("hibernate.cfg.xml");   
		    //creating session factory object  
		    SessionFactory factory=cfg.buildSessionFactory();  
		    //creating session object  
		    Session session=factory.openSession();
		    
		    
		 //1) Write a HQL to fetch employee who do not have managers. 
		    Query q1 =session.createQuery("select e from EmployeeEntity e where e.managerId is null");
		    List<EmployeeEntity> empList1 =q1.list();
		    for(EmployeeEntity em :empList1){
		    	//System.out.println(em);
		    }
		    
		    //2) Write a HQL that give the count of employee for a department. Pass department name as parameter.
		    //(Note: if there is any relationship. Please disable it.)
		    Query q2 =session.createQuery("select count(e.employeeId) as EmpCount from EmployeeEntity e, DepartmentEntity d where e.departmentId=d.deptId and d.deptName =:deptName ");
		    q2.setParameter("deptName", new String("Shipping"));
		    q2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		    List<Map> resultSet=q2.list();
		    for(Map m :resultSet){
		    //	System.out.println("Emp_count :"+ m.get("EmpCount"));
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

	}

}
