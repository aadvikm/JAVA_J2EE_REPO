package com.hibernate.lesson;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class HQLLessonMain {

	public static void main(String[] args) throws Exception{
		//creating configuration object  
	    Configuration cfg=new AnnotationConfiguration();  
	    //populates the data of the configuration file
	    cfg.configure("hibernate.cfg.xml");   
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession(); 
	    Query query = session.createQuery("select e from Employee e where salary > 40000 order by salary desc");
	    List<Employee> empList = query.list();
	    for(Employee emp : empList){
	    	//System.out.println(emp);
	    }
	    query = session.createQuery("select e.firstName, e.lastName, e.salary from Employee e where salary > 40000 order by salary desc");
	    List<Object[]> resultSet = query.list();
	    for(Object[] row : resultSet){
	    	//System.out.println(row[0] +" "+row[1]+ " "+ row[2] );
	    }
	    query = session.createQuery("select e.firstName as FIRSTNAME, e.lastName AS LASTNAME, e.salary AS SALARY from Employee e where salary > 40000 order by salary desc");
	    query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	    List<Map> resultSet1 = query.list();
	    for(Map row : resultSet1){
	    	//System.out.println(row.get("FIRSTNAME") +" "+row.get("LASTNAME")+ " "+row.get("SALARY") );
	    }
	    query = session.createQuery("select e.firstName as FIRSTNAME, e.lastName AS LASTNAME, e.salary as SALARY, d.deptName AS DEPARTMENTNAME from Employee e, DepartmentEntity d where e.departmentId = d.deptId and salary > 40000 order by salary desc");
	    query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	    List<Map> resultSet2 = query.list();
	    for(Map row : resultSet2){
	    	//System.out.println(row.get("FIRSTNAME") +" "+row.get("LASTNAME")+ " "+row.get("SALARY") + " "+row.get("DEPARTMENTNAME"));
	    }
	    query = session.createQuery("select MIN(e.salary) as MINSAL, MAX(e.salary) AS MAXSAL, AVG(e.salary) as AVGSAL from Employee e");
	    query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	    List<Map> resultSet3 = query.list();
	    for(Map row : resultSet3){
	    	//System.out.println(row.get("MINSAL") +" "+row.get("MAXSAL")+ " "+row.get("AVGSAL"));
	    }
	    query = session.getNamedQuery("getMaxMinAvgSalary");
	    query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	    List<Map> resultSet4 = query.list();
	    for(Map row : resultSet4){
	    	//System.out.println(row.get("MINSAL") +" "+row.get("MAXSAL")+ " "+row.get("AVGSAL"));
	    }
	    query = session.getNamedQuery("getDeptMaxMinAvgSalary");
	    query.setParameter("deptId", 10L);
	    query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	    List<Map> resultSet5 = query.list();
	    for(Map row : resultSet5){
	    	System.out.println(row.get("MINSAL") +" "+row.get("MAXSAL")+ " "+row.get("AVGSAL"));
	    }

	}

}
