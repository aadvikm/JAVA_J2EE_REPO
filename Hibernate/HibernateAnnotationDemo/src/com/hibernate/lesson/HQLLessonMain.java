package com.hibernate.lesson;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	    //Fetch all
	    Query query = session.createQuery("select e from Employee e where employeeId>100 order by salary desc");
	    List<Employee> empList = (List<Employee>)query.list();
	    System.out.println("Emp Size : "+empList.size());
	    for(Employee e : empList){
	    	System.out.println(e);
	    }
	    //Fetch with param
	    query = session.createQuery("from Employee where employeeId = :employeeId");
	    query.setParameter("employeeId", 100L);
	    //empList = (List<Employee>)query.list();
	    //System.out.println(empList);
	  //  Transaction tx = session.beginTransaction();
	   // query = session.createQuery("update Employee set salary = salary+1");
	   // System.out.println(query.executeUpdate());
	  //  tx.commit();
	    query = session.createQuery("select max(salary) from Employee");
	    //List<Integer> maxSalary = query.list();
	    //System.out.println(maxSalary.get(0));
	    query = session.createQuery("select e.firstName, e.lastName from Employee e");
	    List<Object[]> result = query.list();
	    for(Object[] objArr : result){
	    	//System.out.println("FirstName : "+objArr[0]);
	    	//System.out.println("LastName : "+objArr[1]);
	    }
	    query = session.createQuery("Select e.firstName, m.firstName from Employee e, Employee m where m.employeeId = e.managerId");
	    List<Object[]> result1 = query.list();
	    for(Object[] objArr : result1){
	    	//System.out.println("Employee FirstName : "+objArr[0]);
	    	//System.out.println("Manager FirstName : "+objArr[1]);
	    }
	    query = session.createQuery("update Employee e set e.salary = e.salary + 1");
	    Transaction tx = session.beginTransaction();
	    //System.out.println("No of rows updated : "+ query.executeUpdate());
	    tx.commit();
	    query = session.createQuery("update Employee e set e.salary = e.salary + 1 where e.employeeId = :empId");
	    query.setParameter("empId", new Long(105));
	    tx = session.beginTransaction();
	    System.out.println("No of rows updated : "+ query.executeUpdate());
	    tx.commit();
	    
	}

}
