package com.hibernate.lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class RelationshipLessonMain {

	public static void main(String[] args) throws Exception{
		//creating configuration object  
	    Configuration cfg=new AnnotationConfiguration();  
	    //populates the data of the configuration file
	    cfg.configure("hibernate.cfg.xml");   
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession();
	    /*DepartmentEntity newDept = new DepartmentEntity();
	    newDept.setDeptName("R Dept");
	    newDept.setLocationId(1700);
	    //newDept.setManagerId(null);
	    Transaction tx = session.beginTransaction();
	    session.save(newDept);
	    tx.commit();
	    System.out.println("Committed!!!");*/
	    //DepartmentEntity deptEntity = (DepartmentEntity) session.get(DepartmentEntity.class, new Integer(20));
	    //System.out.println(deptEntity);
	    Employee employee = (Employee) session.get(Employee.class, 202L);
	    System.out.println(employee);
	    
	    

	}

}
