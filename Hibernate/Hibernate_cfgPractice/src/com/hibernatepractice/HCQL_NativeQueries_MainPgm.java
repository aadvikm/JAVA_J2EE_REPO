package com.hibernatepractice;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;

/*Hibernate Criteria Query:
1) Write a criteria query that will return employee who earn between 30000 to 40000.
2) Write a criteria query to fetch who earn more that 30000 and joined in the year of 2006.
3) Write a criteria query to fetch employee from department 10. Result to be displayed salary decending order. 

Hibernate Native Query:
1) Write a Native Query to fetch employee who do not have managers. 
2) Write a Native Query that give the count of employee for a department. Pass department name as parameter. 
3) Write a Native Query that gives employees from passed location.
4) Write a Native Query to get average salary of passed dept id. 
5) Write a Native Query to get list of employees who earn more than their managers. 
6) Write a Native Query to get employee list with hire date decending order.
7) Write a Native Query to returns following details FirstName, LastName, ManagerFirstName, ManagerLastName, EmpDepartmentName, City. 
8) Take above query transform the result to map and print the details. 
9) Write a Native Query query to fetch only managers. 
10) Write a Native Query to fetch top 3 earning employee. 
11) Wriet a native query to fetch top earning employee with following details employee name, department name, salary. */
public class HCQL_NativeQueries_MainPgm {
	public static void main(String [] args){
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
		    	//System.out.println(emp);
		    }
		    //1) Write a criteria query that will return employee who earn between 5000 to 10000.
		   /* Criterion criterion=Restrictions.between("salary", new BigDecimal(5000), new BigDecimal(10000));
		    criteria.add(criterion);
		    List<EmployeeEntity> empl=criteria.list();
		    for(EmployeeEntity e :empl){
		    	System.out.println(e);
		    }*/
		    
		    //2) Write a criteria query to fetch who earn more that 18000 and joined in the year of 2006.
		    /*Criterion criterion1=Restrictions.gt("salary", new BigDecimal(18000));
		    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		    Criterion criterion2=Restrictions.between("hireDate", sdf.parse("01/01/2006"), sdf.parse("12/31/2006"));
		    criteria.add(criterion1);
		    criteria.add(criterion2);
		    List<EmployeeEntity> employee=criteria.list();
		    for(EmployeeEntity e :employee){
		    	System.out.println(e);
		    }*/
		    
		    //3) Write a criteria query to fetch employee from department 30. Result to be displayed salary decending order.
		    /*Criterion criterion3=Restrictions.eq("departmentId", 30L);
		    criteria.add(criterion3);
		    criteria.addOrder(Order.desc("salary"));
		    List<EmployeeEntity> employees=criteria.list();
		    for(EmployeeEntity es :employees){
		    	System.out.println(es);
		    }*/
		    
		    
		    /*Hibernate Native Query:
		    --------------------------*/
		    
		    //1) Write a Native Query to fetch employee who do not have managers. 
		    /*SQLQuery sqlQuery =session.createSQLQuery("select * from Employees where Manager_Id is null");
		    sqlQuery.addEntity(EmployeeEntity.class);
		    List<EmployeeEntity> empList1 =sqlQuery.list();
		    for(EmployeeEntity ems : empList1){
		    	System.out.println(ems);
		    }*/
		    
		    //2) Write a Native Query that give the count of employee for a department. Pass department name as parameter.
		   /* SQLQuery sqlQuery1=session.createSQLQuery("select count(e.employee_id) from employees e, departments d where e.department_id =d.department_id and d.department_name =:dName");
		    sqlQuery1.setParameter("dName", "Shipping");
		    List<Object> objList =sqlQuery1.list();
		    for(Object obj :objList){
		    	System.out.println("Emp Count :"+obj);
		    }*/
		    
		    //3) Write a Native Query that gives employees from passed location.
		    /*SQLQuery sqlQuery2 =session.createSQLQuery("select e.* from employees e, departments d, locations l where e.department_id =d.department_id and d.location_id =l.location_id and l.city =:city");
		    sqlQuery2.addEntity(EmployeeEntity.class);
		    sqlQuery2.setParameter("city", "London");
		    List<EmployeeEntity> empLoc =sqlQuery2.list();
		    for(EmployeeEntity emLoc :empLoc){
		    	System.out.println(emLoc);
		    }*/
		    
		    //4) Write a Native Query to get average salary of passed dept id. 
		   /* SQLQuery sqlQuery3 =session.createSQLQuery("select avg(salary) from employees where department_id =:deptId");
		    sqlQuery3.setParameter("deptId", 50);
		    List<Object> objList1 =sqlQuery3.list();
		    for(Object obj1 :objList1){
		    	System.out.println("AvgSalary :"+obj1);
		    }	*/
		    
		    //5) Write a Native Query to get list of employees who earn more than their managers.
		    /*SQLQuery sqlQuery4 =session.createSQLQuery("select e.* from employees e, employees m where e.manager_id =m.employee_id and e.salary>m.salary");
		    sqlQuery4.addEntity(EmployeeEntity.class);
		    List<EmployeeEntity> empMoresal =sqlQuery4.list();
		    for(EmployeeEntity empEn : empMoresal){
		    	System.out.println(empEn);
		    }*/
		    
		    
		    //6) Write a Native Query to get employee list with hire date decending order.
		    /*SQLQuery sqlQuery5 =session.createSQLQuery("select * from employees order by hire_date desc");
		    sqlQuery5.addEntity(EmployeeEntity.class);
		    List<EmployeeEntity> empHire =sqlQuery5.list();
		    for(EmployeeEntity emphd : empHire){
		    	System.out.println(emphd);
		    }*/
		    
		    
		    //7) Write a Native Query to returns following 
		    //details FirstName, LastName, ManagerFirstName, ManagerLastName, EmpDepartmentName, City.
		  /* sqlQuery6 =session.createSQLQuery("select e.first_name as empfirst, e.Last_name as emplast, m.first_name as mgrfirst, m.Last_name as mgrLast, d.department_name as empdept, l.city as empcity from employees e, departments d, locations l, employees m, departments md, locations ml where e.department_id=d.department_id and d.location_id =l.location_id and e.manager_id =m.employee_id and m.department_id =md.department_id and md.location_id =ml.location_id");
		    List<Object[]> empMgrDept =sqlQuery6.list();
		    for(Object[] row : empMgrDept){
		    	System.out.println("EmpF_Name :"+row[0]+" ||EmpL_Name : "+row[1]+" ||MgrF_name :"+ row[2]+" ||MgrL_name :"+ row[3] +" ||EmpDept :"+ row[4] +" ||EmpCity :"+row[5]);
		    }
		    
		   // 8) Take above query transform the result to map and print the details. 
		   sqlQuery6.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		   List<Map> resultSet1 = sqlQuery6.list();
		   for(Map row : resultSet1){
		  	System.out.println(row.entrySet());
		    }*/
		   // 9) Write a Native Query query to fetch only managers. 
		    /*SQLQuery sqlQuery7 =session.createSQLQuery("select distinct m.* from employees e, employees m where e.manager_id =m.employee_id");
		    sqlQuery7.addEntity(EmployeeEntity.class);
		    List<EmployeeEntity> mgrDe =sqlQuery7.list();
		    for(EmployeeEntity mgr :mgrDe) {
		    	System.out.println(mgr);
		    }*/
		    
		   // 10) Write a Native Query to fetch top 3 earning employee.
		    /*SQLQuery sqlQuery8 =session.createSQLQuery("select Rownum, first_name, last_name, salary from (select first_name, last_name, salary from employees order by salary desc)  where rownum <=3");
		    List<Object[]> objTop =sqlQuery8.list();
		    for(Object[] obj3 : objTop){
		    	System.out.println("No :"+obj3[0]+ " ||first_name :"+ obj3[1] +" ||last_name :" +obj3[2] +" ||salary :"+ obj3[3]);
		    }*/
		    
		   // 11) Wriet a native query to fetch top earning employee with following details employee name, department name, salary.
		    
		   SQLQuery sqlQuery9 =session.createSQLQuery("select Rownum, first_name, last_name, department_name, salary from (select e.first_name, e.last_name, d.department_name, e.salary from employees e, departments d where e.department_id =d.department_id order by e.salary desc)  where rownum <=3");
		    List<Object[]> objTop =sqlQuery9.list();
		    for(Object[] obj3 : objTop){
		    	System.out.println("No :"+obj3[0]+ " ||first_name :"+ obj3[1] +" ||last_name :" +obj3[2] +" ||dept_name :"+obj3[3]+" ||salary :"+ obj3[4]);
		    }
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
