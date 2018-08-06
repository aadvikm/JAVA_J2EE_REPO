package com.locationCrud;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateLocationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}

	private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if(action.equals("loadUpdatePage")){
			//Do any load logic here..
		}
		else if(action.equals("searchLocation")){//searchLocation
			Session hsession=getHibernateSession();
			String locId =req.getParameter("locId");
			LocationEntity locEntity = (LocationEntity)hsession.get(LocationEntity.class, Integer.parseInt(locId));
			if(locEntity != null){
				req.setAttribute("locationEntity", locEntity);
			}
		}
		else if(action.equals("updateLocation")){
			Session hsession=getHibernateSession();
			String locId =req.getParameter("locId");
			String streetAdd=req.getParameter("streetAdd");
			String postalCode =req.getParameter("postalCode");
			String city =req.getParameter("city");
			String stateProvince =req.getParameter("stateProvince");
			String countryId =req.getParameter("countryId");
			
			LocationEntity locEntity=null;
			Transaction tx =hsession.beginTransaction();
			locEntity = (LocationEntity)hsession.get(LocationEntity.class, Integer.parseInt(locId));
			if(locEntity!=null){
				locEntity.setStreetAdd(streetAdd);
				locEntity.setPostalCode(postalCode);
				locEntity.setCity(city);
				locEntity.setStateProvince(stateProvince);
				locEntity.setCountryId(countryId);
				hsession.update(locEntity);
				tx.commit();
				System.out.println("Updated Successfully..!!");
				req.setAttribute("successMsg", "The location Id "+locId+" has been updated successfully!!!");
				req.setAttribute("locationEntity", locEntity);
			}
		}
		RequestDispatcher redispatcher =req.getRequestDispatcher("views/updatelocation.jsp");
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
