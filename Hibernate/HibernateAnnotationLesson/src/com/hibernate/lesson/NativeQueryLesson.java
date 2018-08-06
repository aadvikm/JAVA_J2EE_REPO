package com.hibernate.lesson;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class NativeQueryLesson {
	public static void main(String[] args) throws Exception{
		//creating configuration object  
	    Configuration cfg=new AnnotationConfiguration();  
	    //populates the data of the configuration file
	    cfg.configure("hibernate.cfg.xml");   
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession(); 
	    SQLQuery sqlQuery = session.createSQLQuery("select * from employees");
	    List<Object[]> resultList = sqlQuery.list();
	    for(Object[] row : resultList){
	    	//System.out.println(row[0]+" "+row[1]);
	    }
	    sqlQuery = session.createSQLQuery("select * from employees");
	    sqlQuery.addEntity(Employee.class);
	    List<Employee> resultList1 = sqlQuery.list();
	    for(Employee emp : resultList1){
	    	//System.out.println(emp);
	    }
	    sqlQuery = session.createSQLQuery("select * from employees where employee_id = :empId");
	    sqlQuery.addEntity(Employee.class);
	    sqlQuery.setParameter("empId", 104L);
	    List<Employee> resultList2 = sqlQuery.list();
	    for(Employee emp : resultList2){
	    	System.out.println(emp);
	    }
	}

}
