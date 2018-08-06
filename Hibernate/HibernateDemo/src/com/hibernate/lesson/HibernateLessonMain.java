package com.hibernate.lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateLessonMain {

	public static void main(String[] args) {
		//creating configuration object  
	    Configuration cfg=new Configuration();  
	    //populates the data of the configuration file
	    cfg.configure("hibernate.cfg.xml");   
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession();  
		try{
		    //creating transaction object  
		    Transaction t=session.beginTransaction();  
		    DepartmentEntity dept = new DepartmentEntity();
		    dept.setDeptId(9006);
		    dept.setDeptName("Hibernate");
		    dept.setLocationId(1700);
		    session.save(dept);
		    t.commit();
		    System.out.println("Committed!!!!");
		}
		catch(Exception exception){
			System.out.println("Errored....");
			exception.printStackTrace();
		}
		finally{
			if(session != null)
				session.close();
		}
	}

}
