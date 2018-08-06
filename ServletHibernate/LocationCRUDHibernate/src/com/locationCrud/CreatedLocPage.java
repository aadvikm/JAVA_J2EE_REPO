package com.locationCrud;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		writer.write("<html>");writer.write("<html>");
		writer.write("<head>");
		writer.write("<meta charset=\"ISO-8859-1\">");
		writer.write("<title>Created Location Page</title>");
		writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
		writer.write("</head>");
		writer.write("<script type='text/javascript' src='js/createpage.js'></script>");
		writer.write("<body>");
		writer.write("<form id='createpage' name='createpage'>");
		writer.write("<img src='images/locimage.png' style='width:800px;height:150px;'>");
		writer.write("<h1>Welcome  "+username+",</h1><br/><br/>");
		writer.write("<table>");
		writer.write("<tr>");
		writer.write("<td colspan=3><h1>You have successfully created a location "+locEntity.getLocId()+" .!! </h1></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>Location Id :</td>");
		writer.write("<td><input type='text' id='locId' name='locId' value ='"+locEntity.getLocId()+"'></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>Street Address :</td>");
		writer.write("<td><input type='text' id='streetAdd' name='streetAdd' value ='"+locEntity.getStreetAdd()+"'></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>Postal Code :</td>");
		writer.write("<td><input type='text' id='postalCode' name='postalCode' value ='"+locEntity.getPostalCode()+"'></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>City :</td>");
		writer.write("<td><input type='text' id='city' name='city' value ='"+locEntity.getCity()+"'></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>State Province:</td>");
		writer.write("<td><input type='text' id='stateProvince' name='stateProvince' value ='"+locEntity.getStateProvince()+"'></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>Country Id:</td>");
		writer.write("<td><input type='text' id='countryId' name='countryId' value ='"+locEntity.getCountryId()+"'></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td><input type='button'  class='button button2' onclick ='createLoc()' value='Create Location'/></td>");
		writer.write("<td><input type='button' class=\"button button2\" onclick='goHome()' value='Go Home'/></td>");
		writer.write("</tr>");
		writer.write("</table>");
		writer.write("</form>");
		writer.write("</body>");
		writer.write("</html>");
		
		
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
