package com.LocationCrud;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LocCrud extends HttpServlet{

	public LocCrud() {
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
		switch ((String) req.getParameter("action")) {
		case "create":
			createLoc(req, resp);
			break;
		case "update":
			updateLoc(req, resp);
			break;
		case "delete":
			deleteLoc(req, resp);
			break;
		default:
			resp.setContentType("application/json");
			PrintWriter writer = resp.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			writer.write(mapper.writeValueAsString("Invalid action."));
		}
	}
	
	private void updateLoc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session hsession = getHibernateSession();
		String locId =req.getParameter("locId");
		String streetAdd =req.getParameter("streetAdd");
		String city =req.getParameter("city");
		String postalCode =req.getParameter("postalCode");
		String stateProvince =req.getParameter("stateProvince");
		String countryId=req.getParameter("countryId");
		
		LocationEntity locEntity =null;
		Transaction tx =hsession.beginTransaction();
		locEntity=(LocationEntity)hsession.get(LocationEntity.class, Long.parseLong(locId));
		if(locEntity !=null){
			locEntity.setLocId(Long.parseLong(locId));
			locEntity.setStreetAdd(streetAdd);
			locEntity.setCity(city);
			locEntity.setPostalCode(postalCode);
			locEntity.setStateProvince(stateProvince);
			locEntity.setCountryId(countryId);
			hsession.update(locEntity);
			tx.commit();
			System.out.println("Updated Successfully..!!!!!!");
		}
		LocationDetail locDetail = getLocDetail(locEntity.getLocId().toString());
		
		
		
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(locDetail));
		writer.write(mapper.writeValueAsString(locDetail));
	}
	
	public void createLoc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session hsession = getHibernateSession();
		HttpSession session =req.getSession();
		LocationEntity locEntity =new LocationEntity();
		
		String streetAdd =req.getParameter("streetAdd");
		String city =req.getParameter("city");
		String postalCode =req.getParameter("postalCode");
		String stateProvince =req.getParameter("stateProvince");
		String countryId =req.getParameter("countryId");
		try{
			locEntity.setStreetAdd(streetAdd);
			locEntity.setCity(city);
			locEntity.setPostalCode(postalCode);
			locEntity.setStateProvince(stateProvince);
			locEntity.setCountryId(countryId);
			Transaction tx =hsession.beginTransaction();
			hsession.persist(locEntity);
			tx.commit();
			System.out.println("New Location Created Successfully..!!");
		}catch(Exception e){
			e.printStackTrace();
			resp.setContentType("plain/text");
			PrintWriter writer = resp.getWriter();
			writer.write("Exception Occurred.");
			return;
		}
		LocationDetail locDetail = getLocDetail(locEntity.getLocId().toString());
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(locDetail));
		writer.write(mapper.writeValueAsString(locDetail));
	}

	public void deleteLoc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String locId =req.getParameter("locId");
			Session hsession = getHibernateSession();
			LocationEntity locEntity =null;
			Transaction tx =hsession.beginTransaction();
			locEntity=(LocationEntity)hsession.get(LocationEntity.class, Long.parseLong(locId));
			if(locEntity !=null){
				hsession.delete(locEntity);
				tx.commit();
				System.out.println("Deleted Successfully..!!!!!");
			}
			resp.setContentType("application/json");
			PrintWriter writer = resp.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			writer.write(mapper.writeValueAsString("Location is deleted successfully."));
	}
	
	private LocationDetail getLocDetail(String locId){
		
		Session hsession = getHibernateSession();
		LocationDetail locDetail =new LocationDetail();
		locDetail.setLocId(Long.parseLong(locId));
		Query query =hsession.createSQLQuery("Select city as city, street_address as streetAdd, postal_code as postalCode, state_province as stateProvince, country_id as countryId from locations where state_province is not null and location_id ="+locId);
		
		for(Object obj :query.list()){
			Object[] objArr =(Object[]) obj;
			locDetail.setCity(String.valueOf(objArr[0]));
			locDetail.setStreetAdd((String.valueOf(objArr[1])));
			locDetail.setPostalCode(String.valueOf(objArr[2]));
			locDetail.setStateProvince(String.valueOf(objArr[3]) ==null? null : String.valueOf(objArr[3]));
			locDetail.setCountryId(String.valueOf(objArr[4]) ==null ? null : String.valueOf(objArr[4]));
		}

		SQLQuery query2 =hsession.createSQLQuery("Select cast(country_id as varchar2(100)) as countryId, country_name as countryName from countries");
		ArrayList<Country> countryList=new ArrayList<Country>();
		for(Object obj : query2.list()){
			Object[] objArr = (Object[]) obj;
			Country coutry =new Country((String)objArr[0] ==null ? null :(String)objArr[0]);
			countryList.add(coutry);
		}
		locDetail.setCountryList(countryList);
		
		return locDetail;
	}
	private Session getHibernateSession() {
		try{
		// creating configuration object
		Configuration cfg = new Configuration();
		// populates the data of the configuration file
		cfg.configure("hibernate.cfg.xml");
		// creating session factory object
		SessionFactory factory = cfg.buildSessionFactory();
		// creating session object
		Session session = factory.openSession();
		return session;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
