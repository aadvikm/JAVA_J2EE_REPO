package com.hibernate.lesson;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class HCQLLessonMain {

	public static void main(String[] args) throws Exception {
		//creating configuration object  
	    Configuration cfg=new AnnotationConfiguration();  
	    //populates the data of the configuration file
	    cfg.configure("hibernate.cfg.xml");   
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession(); 
	    Criteria criteria = session.createCriteria(Employee.class);
	    List<Employee> empList =  criteria.list();
	    for(Employee emp : empList){
	    	//System.out.println(emp);
	    }
	    //Criterion criterian = Restrictions.gt("salary",new BigDecimal("40000"));
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    Criterion criterian = Restrictions.between("hireDate", sdf.parse("01/01/2006"), sdf.parse("12/31/2006"));
	    Criterion criterian1 = Restrictions.like("firstName", "S%");
	    
	    /**
	     * Restrictions class:
	      -------------------
			Restrictions class provides methods that can be used as Criterion. The commonly used methods of Restrictions class are as follows:
			
			public static SimpleExpression lt(String propertyName,Object value) sets the less than constraint to the given property.
			public static SimpleExpression le(String propertyName,Object value) sets the less than or equal constraint to the given property.
			public static SimpleExpression gt(String propertyName,Object value) sets the greater than constraint to the given property.
			public static SimpleExpression ge(String propertyName,Object value) sets the greater than or equal than constraint to the given property.
			public static SimpleExpression ne(String propertyName,Object value) sets the not equal constraint to the given property.
			public static SimpleExpression eq(String propertyName,Object value) sets the equal constraint to the given property.
			public static Criterion between(String propertyName, Object low, Object high) sets the between constraint.
			public static SimpleExpression like(String propertyName, Object value) sets the like constraint to the given property.
	     */
	    criteria.add(criterian);
	    criteria.add(criterian1);
	    List<Employee> result1 = criteria.list();
	    for(Employee e : result1){
	    	System.out.println(e);
	    }
	   

	}

}
