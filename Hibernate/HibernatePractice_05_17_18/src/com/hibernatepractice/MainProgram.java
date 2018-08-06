package com.hibernatepractice;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class MainProgram {

	public MainProgram() {
		super();
	}

	public static void main(String[] args) {
		try{
			Configuration cfg=new AnnotationConfiguration();  
		    //populates the data of the configuration file
		    cfg.configure("hibernate.cfg.xml");   
		    //creating session factory object  
		    SessionFactory factory=cfg.buildSessionFactory();  
		    //creating session object  
		    Session session=factory.openSession();
		    
		    //To Save
		    
		    /*EmployeeEntity emp =new EmployeeEntity();
		    emp.setCommissionPct(null);
		    emp.setDepartmentId(20L);
		    emp.setEmail("Brindha.damu");
		    emp.setFirstName("Senthurnathan");
		    SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		    Date d =sdf.parse("17/05/2005");
		    emp.setHireDate(d);
		    emp.setJobId("IT_PROG");
		    emp.setLastName("Damodaran");
		    emp.setManagerId(102L);
		    emp.setOldSal(new BigDecimal(11000));
		    emp.setPhoneNumber("9884460222");
		    emp.setSalary(new BigDecimal(16000));
		    
		    Transaction tx =session.beginTransaction();
		    session.save(emp);
		    tx.commit();
			System.out.println("!!--- New Employee Created Successfully---!!" );
			*/
			
			//To Fetch
		    
		   /* Transaction tx =session.beginTransaction();
			EmployeeEntity employee=(EmployeeEntity)session.get(EmployeeEntity.class, 306L);
			System.out.println(employee);*/
			
			
			//To Update
			
			/*employee.setCommissionPct(new BigDecimal(0.52));
			System.out.println("!!--Data Updated Successfully--!!");
			tx.commit();
			System.out.println(employee);*/
		    
		    
		    //To Delete
		    
		  /*  session.delete(employee);
		    tx.commit();
		    System.out.println("!!-- Data Deleted Successfully--!!");*/
			
			
			//DepartmentEntity
		    //To Save
		   /* DepartmentEntity deptEntity =new DepartmentEntity();
		    
		    deptEntity.setDeptName("MyOwnDept");
		    deptEntity.setLocationId(1700);
		    deptEntity.setManagerId(100L);
		    
		    Transaction t =session.beginTransaction();
		    session.save(deptEntity);
		    t.commit();
		    
		    System.out.println("!!--New Department Created Successfully--!!");*/
		    
		    
		    //To fetch
		   /* Transaction t =session.beginTransaction();
		    DepartmentEntity dept=(DepartmentEntity)session.get(DepartmentEntity.class, 1520);
		    System.out.println(dept);*/
		    
			//To Update
		    
		   /* dept.setDeptName("My Own Department");
		    t.commit();
		    System.out.println("!!--Data Updated Successfully--!!");*/
		    
		    //To Delete
		    
		   /* session.delete(dept);
		    t.commit();
		    System.out.println("!!-- Data Deleted Successfully--!!");*/
		    
		    
		    /*Employee and Department Relationship:-
		    ----------------------------------------*/
		    Transaction tx =session.beginTransaction();
		    EmployeeEntity empEntity =(EmployeeEntity)session.get(EmployeeEntity.class, new Long(102));
		  //  System.out.println(empEntity);
		    
		    DepartmentEntity deptEntity =(DepartmentEntity)session.get(DepartmentEntity.class, 20);
		    System.out.println(deptEntity);
		    
		    
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			System.out.println("!!..Finally Block..!!");
		}

	}

}
