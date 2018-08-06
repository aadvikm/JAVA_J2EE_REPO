package com.hibernate.exercise;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

//3) Demo a rollback function using Country Entity. Just udpate and entity and rollback the changes. 
public class MainProgram {

	public static void main(String[] args) {
		try{
				//creating configuration object  
			    Configuration cfg=new AnnotationConfiguration();  
			    //populates the data of the configuration file
			    cfg.configure("hibernate.cfg.xml");   
			    //creating session factory object  
			    SessionFactory factory=cfg.buildSessionFactory();  
			    //creating session object  
			    Session session=factory.openSession();
			   
			    //To Save..
			    
			    /*LocationEntity locEntity =new LocationEntity();
			    locEntity.setStreetAddress("26,BrindavanIllam");
			    locEntity.setPostalCode("600063");
			    locEntity.setCity("Chennai");
			    locEntity.setStateProvince("Tamilnadu");
			    locEntity.setCountryId("IN");
			    
			    Transaction tx = session.beginTransaction();
			    session.save(locEntity);
			    System.out.println("Committed..!!!!");
			    System.out.println(locEntity);
			    tx.commit();*/
			    
			    
			    //To Fetch..
			   // Transaction tx = session.beginTransaction();
			    //LocationEntity locEntity2 =(LocationEntity)session.get(LocationEntity.class, new Integer(9300));
			    //System.out.println(locEntity2);
			    
			    //To Update
			    /*locEntity2.setStreetAddress("26, Brindavanam Illam, Perungalathur");
			    session.update(locEntity2);
			    System.out.println("Updated Successfully..!!");
			    tx.commit();
			    System.out.println(locEntity2);*/
			    
			    //To Delete
			    /*session.delete(locEntity2);
			    tx.commit();
			    System.out.println("Deleted..!!!");*/
			    
			    
			    /*Countries..............!!*/
			    
			    //To Save
			    /*CountryEntity couEntity =new CountryEntity();
			   	couEntity.setCountryId("VI");
			    couEntity.setCountryName("Vietnam");
			    couEntity.setRegionId(3);
			    Transaction tx = session.beginTransaction();
			    session.save(couEntity);
			    tx.commit();
			    System.out.println(couEntity);
			    System.out.println("Committed...!!!");*/
			    
			    
			    //To Fetch
			    
			    //CountryEntity couEntity1=(CountryEntity)session.get(CountryEntity.class, new String("IN"));
			    //System.out.println(couEntity1);
			    
			    //To Update
			   // CountryEntity couEntity2=(CountryEntity)session.get(CountryEntity.class, new String("VI"));
			    /*couEntity2.setCountryName("Venesula");
			    Transaction tx = session.beginTransaction();
			    session.update(couEntity2);
			    tx.commit();
			    System.out.println(couEntity2);
			    System.out.println("Updated Successfully..!!");*/
			    
			    //To Delete
			   /* Transaction tx = session.beginTransaction();
			   session.delete(couEntity2);
			   System.out.println("Deleted Successfully..!!");
			    tx.commit();*/
			    
			    
			   /* CountryEntity couEntity3=(CountryEntity)session.get(CountryEntity.class, new String("IN"));
			    couEntity3.setRegionId(2);
			    Transaction tx = session.beginTransaction();
			    session.update(couEntity3);
			    System.out.println(couEntity3);
			    System.out.println("Updated Successfully..!!");
			    tx.rollback();
			    System.out.println("Rollbacked..!!");*/
			    
			    
			    //LocationEntity and CountryEntity Relationship
			    Transaction tx = session.beginTransaction();
			   // LocationEntity locEntity2 =(LocationEntity)session.get(LocationEntity.class, new Integer(1700));
			   // System.out.println(locEntity2);
			    
			    
			    CountryEntity couEntity1=(CountryEntity)session.get(CountryEntity.class, new String("US"));
			    System.out.println(couEntity1);
			    
			}
		catch(Exception ex){
			ex.printStackTrace();
		}
	    finally{
	    	System.out.println("Finally Block..!!!");
	    }
	 
	    
	    

	}

}
