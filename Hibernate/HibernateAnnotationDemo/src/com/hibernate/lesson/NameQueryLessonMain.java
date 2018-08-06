package com.hibernate.lesson;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class NameQueryLessonMain {

	public static void main(String[] args) {
		//creating configuration object  
	    Configuration cfg=new AnnotationConfiguration();  
	    //populates the data of the configuration file
	    cfg.configure("hibernate.cfg.xml");   
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession(); 
	    Query query = session.getNamedQuery("getAllManagers");
	    List<Employee> mgrList = query.list();
	    for(Employee manager : mgrList){
	    	System.out.println(manager);
	    }
	    
	    Query query2 = session.getNamedQuery("getMangerDetail");
	    query2.setParameter("empId", 205L);
	    List<Employee> manager = query2.list();
	    System.out.println(manager.get(0));
	}

}
