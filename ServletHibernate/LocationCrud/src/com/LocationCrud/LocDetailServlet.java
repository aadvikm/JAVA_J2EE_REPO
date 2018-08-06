package com.LocationCrud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class LocDetailServlet extends HttpServlet {

	public LocDetailServlet() {
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
	try{
		HttpSession session = req.getSession();
		Session hsession = getHibernateSession();
		
		String locId =req.getParameter("locId");
		LocationDetail locDetail =new LocationDetail();
		locDetail.setLocId(Long.parseLong(locId));
		Query query =hsession.createSQLQuery("Select city as city, street_address as streetAdd, postal_code as postalCode, state_province as stateProvince, cast(country_id as varchar2(100)) as countryId  from locations where  location_id ="+locId);
		
		for(Object obj :query.list()){
			Object[] objArr =(Object[]) obj;
			locDetail.setCity(String.valueOf(objArr[0]));
			locDetail.setStreetAdd((String.valueOf(objArr[1])));
			locDetail.setPostalCode(String.valueOf(objArr[2]));
			locDetail.setStateProvince(objArr[3] ==null? null : String.valueOf(objArr[3]));
			locDetail.setCountryId(objArr[4]==null? null: String.valueOf(objArr[4]));
		}
		
		SQLQuery query2 =hsession.createSQLQuery("Select cast(country_id as varchar2(100)) as countryId, country_name as countryName from countries");
		ArrayList<Country> countryList=new ArrayList<Country>();
		for(Object obj : query2.list()){
			Object[] objArr = (Object[]) obj;
			Country coutry =new Country((String)objArr[0] ==null ? null :(String)objArr[0]);
			countryList.add(coutry);
		}
		locDetail.setCountryList(countryList);
		
		resp.setContentType("application/json ");
		PrintWriter writer = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(locDetail));
		writer.write(mapper.writeValueAsString(locDetail));
	}
	catch(Exception exception){
		exception.printStackTrace();
		throw exception;
	}
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
