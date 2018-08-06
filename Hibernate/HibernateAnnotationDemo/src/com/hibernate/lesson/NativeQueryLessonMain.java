package com.hibernate.lesson;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class NativeQueryLessonMain {

	public static void main(String[] args){
		//creating configuration object  
	    Configuration cfg=new AnnotationConfiguration();  
	    //populates the data of the configuration file
	    cfg.configure("hibernate.cfg.xml");   
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession();
	    SQLQuery query = session.createSQLQuery("Select * from employees");
	    query.addEntity(Employee.class);
	    List<Employee> empList = query.list();
	    for(Employee e : empList){
	    	System.out.println(e);
	    }
	    
	    query = session.createSQLQuery("Select e.* from employees e where salary > :sal");
	    query.addEntity(Employee.class);
	    query.setParameter("sal", new BigDecimal("15000"));
	    List<Employee> empSalGreaterThanList = query.list();
	    for(Employee e : empSalGreaterThanList){
	    	System.out.println(e);
	    }
	    
	    query = session.createSQLQuery("select d.department_name, e.first_name, e.last_name from employees e, departments d where d.department_id = e.department_id");
	    List<Object[]> resultList = query.list();
	    for(Object[] val : resultList){
	    	System.out.println(val[0] +" "+ val[1] +" "+ val[2]);
	    }
	    
	    query = session.createSQLQuery("select d.department_name, e.first_name as firstName, e.last_name as lastName from employees e, departments d where d.department_id = e.department_id");
	    query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	    List resultList1 = query.list();
	    for(Object data : resultList1){
	    	Map map = (Map) data;
	    	System.out.println(map.get("DEPARTMENT_NAME") +" "+ map.get("FIRSTNAME") +" "+ map.get("LASTNAME"));
	    }
	    
	    
	    
	    
	}
}
