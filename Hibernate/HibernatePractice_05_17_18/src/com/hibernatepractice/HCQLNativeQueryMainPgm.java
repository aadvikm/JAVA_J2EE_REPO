package com.hibernatepractice;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HCQLNativeQueryMainPgm {

	public HCQLNativeQueryMainPgm() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String []args){
		try{
			
			//creating configuration object  
		    Configuration cfg=new AnnotationConfiguration();  
		    //populates the data of the configuration file
		    cfg.configure("hibernate.cfg.xml");   
		    //creating session factory object  
		    SessionFactory factory=cfg.buildSessionFactory();  
		    //creating session object  
		    Session session=factory.openSession();
		    
		    Criteria criteria=session.createCriteria(EmployeeEntity.class);
		    List<EmployeeEntity> empList =  criteria.list();
		    for(EmployeeEntity emp : empList){
		    //	System.out.println(emp);
		    }
		    
		    

		 /*   //1) Write a criteria query that will return employee who earn between 5000 to 10000.
		    Criterion criterion=Restrictions.between("salary", new BigDecimal(5000), new BigDecimal(10000));
		    criteria.add(criterion);
		    List<EmployeeEntity> empl=criteria.list();
		    for(EmployeeEntity e :empl){
		 //   	System.out.println(e);
		    }
		    
		    //2) Write a criteria query to fetch who earn more that 18000 and joined in the year of 2006.
		    Criterion criterion1=Restrictions.gt("salary", new BigDecimal(4000));
		    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		    Criterion criterion2=Restrictions.between("hireDate", sdf.parse("01/01/2006"), sdf.parse("12/31/2006"));
		    criteria.add(criterion1);
		    criteria.add(criterion2);
		    List<EmployeeEntity> employee=criteria.list();
		    for(EmployeeEntity e :employee){
		    //	System.out.println(e);
		    }
		    
		    //3) Write a criteria query to fetch employee from department 30. Result to be displayed salary decending order.
		    Criterion criterion3=Restrictions.eq("departmentId", 50L);
		    criteria.add(criterion3);
		    criteria.addOrder(Order.desc("salary"));
		    List<EmployeeEntity> employees=criteria.list();
		    for(EmployeeEntity es :employees){
		    //	System.out.println(es);
		    }*/
		    
		    
		    /*Hibernate Native Query:
		    --------------------------*/
		    
		    //1) Write a Native Query to fetch employee who do not have managers. 
		    SQLQuery sqlQuery =session.createSQLQuery("select * from Employees where Manager_Id is null");
		    sqlQuery.addEntity(EmployeeEntity.class);
		    List<EmployeeEntity> empList1 =sqlQuery.list();
		    for(EmployeeEntity ems : empList1){
		    	//System.out.println(ems);
		    }
		    
		    //2) Write a Native Query that give the count of employee for a department. Pass department name as parameter.
		    SQLQuery sqlQuery1=session.createSQLQuery("select count(e.employee_id) from employees e, departments d where e.department_id =d.department_id and d.department_name =:dName");
		    sqlQuery1.setParameter("dName", "Shipping");
		    List<Object> objList =sqlQuery1.list();
		    for(Object obj :objList){
		    	//System.out.println("Emp Count :"+obj);
		    }
		    
		    //3) Write a Native Query that gives employees from passed location.
		    SQLQuery sqlQuery2 =session.createSQLQuery("select e.* from employees e, departments d, locations l where e.department_id =d.department_id and d.location_id =l.location_id and l.city =:city");
		    sqlQuery2.addEntity(EmployeeEntity.class);
		    sqlQuery2.setParameter("city", "London");
		    List<EmployeeEntity> empLoc =sqlQuery2.list();
		    for(EmployeeEntity emLoc :empLoc){
		    	//System.out.println(emLoc);
		    }
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
