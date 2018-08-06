package com.LocationCrud;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class LocServlet extends HttpServlet{

	public LocServlet() {
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
		SQLQuery query =hsession.createSQLQuery("Select location_id as locId, city as city from locations");
		
		ArrayList<LocationField> locList =new ArrayList<LocationField>();

		for (Object obj : query.list()) {
			Object[] objArr = (Object[]) obj;
			LocationField loc =new LocationField(((BigDecimal)objArr[0]).longValue(), (String)objArr[1]);
			locList.add(loc);
		}
		
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(locList));
		writer.write(mapper.writeValueAsString(locList));
		
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
