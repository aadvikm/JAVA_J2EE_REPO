package com.servletpractice10;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Servlet Context is initialized...");
		ServletContext servletContext = arg0.getServletContext();
		servletContext.setAttribute("appName", "Servlet Learning...");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Servlet Context is destroyed...");
		
	}

}
