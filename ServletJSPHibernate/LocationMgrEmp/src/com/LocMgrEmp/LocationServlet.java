package com.LocMgrEmp;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class LocationServlet extends HttpServlet {

	public LocationServlet() {
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
		HttpSession session = req.getSession();
		Session hsession = getHibernateSession();
		
		SQLQuery query =hsession.createSQLQuery("Select Location_id as locId, city as city from Locations");
		
		ArrayList<Location> locList =new ArrayList<Location>();
		
		for (Object obj : query.list()) {
			Object[] objArr = (Object[]) obj;
			Location locEntity =new Location(((BigDecimal)objArr[0]).longValue(), ((String)objArr[1]));
			locList.add(locEntity);
		}
		req.setAttribute("locList", locList);

		RequestDispatcher reqDispatcher = req.getRequestDispatcher("views/locationPage.jsp");
		reqDispatcher.forward(req, resp);
	}
	
	private Session getHibernateSession(){
		 Configuration cfg=new AnnotationConfiguration();  
		    //populates the data of the configuration file
		    cfg.configure("hibernate.cfg.xml");   
		    //creating session factory object  
		    SessionFactory factory=cfg.buildSessionFactory();  
		    //creating session object  
		    Session session=factory.openSession(); 
	    return session;
	}

}
