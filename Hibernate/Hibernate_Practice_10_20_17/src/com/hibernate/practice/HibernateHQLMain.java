package com.hibernate.practice;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateHQLMain {

	public static void main(String[] args) {
		//creating configuration object  
	    Configuration cfg=new AnnotationConfiguration();  
	    //populates the data of the configuration file
	    cfg.configure("hibernate.cfg.xml");   
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession(); 
	    
	    Query q = session.createQuery("select e from Employee e where salary > 40000 order by salary desc");
	    List<Employee> empList = q.list();
	    for(Employee emp : empList){
	    	//System.out.println(emp);
	    }
	    
	    q = session.createQuery("select e.firstName, e.lastName, e.salary from Employee e where salary > 40000 order by salary desc");
	    List<Object[]> resultSet = q.list();
	    Iterator i = resultSet.iterator();
	    while(i.hasNext()){
	    	Object[] obj =(Object[])i.next();
	    	//System.out.println(obj[0] +" "+obj[1]+ " "+ obj[2] );
	    }
	  
	    q = session.createQuery("select e.firstName as FIRSTNAME, e.lastName AS LASTNAME, e.salary AS SALARY from Employee e where salary > 40000 order by salary desc");
	    q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	    List<Map> resultSet1 = q.list();
	    for(Map row : resultSet1){
	    	//System.out.println(row.get("FIRSTNAME") +" "+row.get("LASTNAME")+ " "+row.get("SALARY") );
	    }
	    
	    
	    q = session.createQuery("select e.firstName as FIRSTNAME, e.lastName AS LASTNAME, e.salary as SALARY, d.deptName AS DEPARTMENTNAME from Employee e, DepartmentEntity d where e.departmentId = d.deptId and salary > 40000 order by salary desc");
	    q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	    List<Map> resultSet2 = q.list();
	    for(Map row : resultSet2){
	    	//System.out.println(row.get("FIRSTNAME") +" "+row.get("LASTNAME")+ " "+row.get("SALARY") + " "+row.get("DEPARTMENTNAME"));
	    }
	    q = session.createQuery("select MIN(e.salary) as MINSAL, MAX(e.salary) AS MAXSAL, AVG(e.salary) as AVGSAL from Employee e");
	    q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	    List<Map> resultSet3 = q.list();
	    for(Map row : resultSet3){
	    	//System.out.println(row.get("MINSAL") +" "+row.get("MAXSAL")+ " "+row.get("AVGSAL"));
	    }

	    q = session.createQuery("select d from DepartmentEntity d");
	    List<DepartmentEntity> deptList = q.list();
	    for(DepartmentEntity dept : deptList){
	    	//System.out.println(dept);
	    }
	    
	    q = session.createQuery("select d from DepartmentEntity d where deptId =10");
	    List<DepartmentEntity> deptList1 = q.list();
	    for(DepartmentEntity dept1 : deptList1){
	    	//System.out.println(dept1);
	    }
	    
	    q = session.createQuery("select d from DepartmentEntity d where deptName ='Shipping'");
	    List<DepartmentEntity> deptList2 = q.list();
	    for(DepartmentEntity dept2 : deptList2){
	    	//System.out.println(dept2);
	    }
	    
	    q = session.createQuery("select d from DepartmentEntity d, Employee e where e.departmentId = d.deptId and d.locationId =1700");
	    List<DepartmentEntity> deptList3 = q.list();
	    for(DepartmentEntity dept3 : deptList3){
	    	System.out.println(dept3);
	    }


	}

}
