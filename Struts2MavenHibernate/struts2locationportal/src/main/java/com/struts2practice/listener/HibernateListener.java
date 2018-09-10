package com.struts2practice.listener;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateListener implements ServletContextListener{
 
    private Configuration config;
    private SessionFactory factory;
    private String path = "/hibernate.cfg.xml";
 
    public static final String KEY_NAME = "HibernateListener";

	public void contextDestroyed(ServletContextEvent event) {
	  // Do nothing...
	}
 
	public void contextInitialized(ServletContextEvent event) {
 
	 try { 
	        URL url = HibernateListener.class.getResource(path);
	        config = new Configuration().configure(url);
	        factory = config.buildSessionFactory();
	         
	        //save the Hibernate session factory into serlvet context
	        event.getServletContext().setAttribute(KEY_NAME, factory);
	  } catch (Exception e) {
	         System.out.println(e.getMessage());
	   }
	}
}