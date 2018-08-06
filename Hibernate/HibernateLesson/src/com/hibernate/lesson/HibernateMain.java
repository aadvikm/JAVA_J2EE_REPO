package com.hibernate.lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

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
	    	Transaction t = session.beginTransaction();
	    	DepartmentEntity dept = new DepartmentEntity();
	    	dept.setDeptId(9800);
	    	dept.setDeptName("HibernateDept");
	    	dept.setLocationId(1700);
	    	dept.setManagerId(null);
	    	
	    	//To Save
	    	//session.save(dept);
	    	t.commit();
	    	System.out.println("Committed Successfully!!!");
	    	
	    	//To Fetch
	    	DepartmentEntity fetchedEntity = (DepartmentEntity) session.get(DepartmentEntity.class, 9700);
	    	System.out.println("Fetched Entity...."+fetchedEntity);
	    	
	    	//To Update
	    	t = session.beginTransaction();
	    	fetchedEntity.setDeptName("NewDept");
	    	session.update(fetchedEntity);
	    	t.commit();
	    	System.out.println("Updated Successfully.");
	    	
	    	//To Delete 
	    	t = session.beginTransaction();
	    	session.delete(fetchedEntity);
	    	t.commit();
	    	System.out.println("Deleted Successfully.");
	    	
	    }
	    catch(Exception exception){
	    	exception.printStackTrace();
	    }
	    finally{
	    	if(session != null)
	    		session.close();
	    }
		

	}

}
