package com.hibernate.lesson;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * The Hibernate Criteria Query Language (HCQL) is used to fetch the records based on the specific criteria. 
 * The Criteria interface provides methods to apply criteria such as retreiving all the records of table whose salary is greater than 50000 etc.
 * 
 * Advantage of HCQLThe HCQL provides methods to add criteria, so it is easy for the java programmer to add criteria. 
 * The java programmer is able to add many criteria on a query.
 * 
 * The commonly used methods of Criteria interface are as follows:
 * 
 * public Criteria add(Criterion c) is used to add restrictions.
 * public Criteria addOrder(Order o) specifies ordering.
 * public Criteria setFirstResult(int firstResult) specifies the first number of record to be retreived.
 * public Criteria setMaxResult(int totalResult) specifies the total number of records to be retreived.
 * public List list() returns list containing object.
 * public Criteria setProjection(Projection projection) specifies the projection.
 * 
 * @author Brindha
 *
 */
public class HCQLLessonMain {

	public static void main(String[] args) throws Exception{
		//creating configuration object  
	    Configuration cfg=new AnnotationConfiguration();  
	    //populates the data of the configuration file
	    cfg.configure("hibernate.cfg.xml");   
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession(); 
	    Criteria criteria = session.createCriteria(Employee.class);
	    List<Employee> result = criteria.list();
	    for(Employee e : result){
	    	//System.out.println(e);
	    }
	    criteria = session.createCriteria(Employee.class);
	    criteria.add(Restrictions.gt("salary",new BigDecimal("10000")));
	    List<Employee> result1 = criteria.list();
	    for(Employee e : result1){
	    	System.out.println(e);
	    }
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
	    

	}

}
