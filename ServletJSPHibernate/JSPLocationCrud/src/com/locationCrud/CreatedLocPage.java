package com.locationCrud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreatedLocPage extends HttpServlet {

	public CreatedLocPage() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession();
		String username =(String)session.getAttribute("username");
		Session hsession=getHibernateSession();
		
		String streetAdd=req.getParameter("streetAdd");
		String postalCode =req.getParameter("postalCode");
		String city =req.getParameter("city");
		String stateProvince =req.getParameter("stateProvince");
		String countryId =req.getParameter("countryId");
		
		LocationEntity locEntity =new LocationEntity();
		locEntity.setStreetAdd(streetAdd);
		locEntity.setPostalCode(postalCode);
		locEntity.setCity(city);
		locEntity.setStateProvince(stateProvince);
		locEntity.setCountryId(countryId);
		
		Transaction tx =hsession.beginTransaction();
		hsession.persist(locEntity);
		tx.commit();
		System.out.println("Committe Successfully.>!!");
		
		req.setAttribute("locationEntity", locEntity);
		RequestDispatcher redispatcher =req.getRequestDispatcher("views/createdPage.jsp");
		redispatcher.forward(req, resp);
	
		
		
	}
	
	private Session getHibernateSession(){
		//creating configuration object  
	    Configuration cfg=new Configuration();  
	    //populates the data of the configuration file
	    cfg.configure("hibernate.cfg.xml");   
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession();
	    return session;
	}

}
