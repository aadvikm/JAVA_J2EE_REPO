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
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CountryListServlet extends HttpServlet{

	public CountryListServlet() {
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
			
			SQLQuery query =hsession.createSQLQuery("Select cast(country_id as varchar2(100)) as countryId, country_name as countryName from countries");
			ArrayList<Country> countryList=new ArrayList<Country>();
			for(Object obj : query.list()){
				Object[] objArr = (Object[]) obj;
				Country coutry =new Country((String)objArr[0] ==null ? null :(String)objArr[0]);
				countryList.add(coutry);
			}
			CountryList countryL =new CountryList();
			countryL.setCountryList(countryList);
			
			resp.setContentType("application/json");
			PrintWriter writer = resp.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writeValueAsString(countryL));
			writer.write(mapper.writeValueAsString(countryL));
		}
		catch(Exception ex){
			ex.printStackTrace();
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
