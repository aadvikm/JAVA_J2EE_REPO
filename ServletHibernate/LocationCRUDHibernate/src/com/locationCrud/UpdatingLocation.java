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
import org.hibernate.cfg.Configuration;

public class UpdatingLocation extends HttpServlet {

	public UpdatingLocation() {
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
		
		String locId =req.getParameter("locId");
		LocationEntity locEntity = (LocationEntity)hsession.get(LocationEntity.class, Integer.parseInt(locId));
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		if(locEntity != null){
			writer.write("<html>");
			writer.write("<head>");
			writer.write("<meta charset=\"ISO-8859-1\">");
			writer.write("<title>Updating Location Page</title>");
			writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
			writer.write("</head>");
			writer.write("<script type='text/javascript' src='js/updatepage.js'></script>");
			writer.write("<body>");
			writer.write("<form id='updatepage' name='updatepage'>");
			writer.write("<img src='images/locimage.png' style='width:800px;height:150px;'>");
			writer.write("<h1>Welcome  "+username+",</h1><br/><br/>");
			writer.write("<table>");
			writer.write("<tr>");
			writer.write("<td>Location Id: </td>");
			writer.write("<td><input type='text' id='locId' name='locId' value='"+locId+"'/></td>");
			writer.write("<td><input type='button' class='button button2' onClick='findLoc()' value='Search Location'/></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td>Street Address : </td>");
			writer.write("<td><input type='text' id='streetAdd' name='streetAdd' value='"+locEntity.getStreetAdd()+"'/></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td>Postal Code : </td>");
			writer.write("<td><input type='text' id='postalCode' name='postalCode' value='"+locEntity.getPostalCode()+"'/></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td>City : </td>");
			writer.write("<td><input type='text' id='city' name='city' value='"+locEntity.getCity()+"'/></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td>State Province : </td>");
			writer.write("<td><input type='text' id='stateProvince' name='stateProvince' value='"+locEntity.getStateProvince()+"'/></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td>Country Id : </td>");
			writer.write("<td><input type='text' id='countryId' name='countryId' value='"+locEntity.getCountryId()+"'/></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td colspan=3><input type='button' class=\"button button2\" onclick='updateLoc()' value='Update Location'/></td>");
			writer.write("<td colspan=3><input type='button' class=\"button button2\" onclick='goHome()' value='Go Home'/></td>");
			writer.write("</tr>");
			writer.write("</table>");
			writer.write("</form>");
			writer.write("</body>");
			writer.write("</html>");
		}
		else{
			writer.write("<html>");
			writer.write("<head>");
			writer.write("<meta charset=\"ISO-8859-1\">");
			writer.write("<title>Update Location Page</title>");
			writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
			writer.write("</head>");
			writer.write("<script type='text/javascript' src='js/updatepage.js'></script>");
			writer.write("<body>");
			writer.write("<form id='updatepage' name='updatepage'>");
			writer.write("<img src='images/locimage.png' style='width:800px;height:150px;'>");
			writer.write("<h1>Welcome  "+username+",</h1><br/><br/>");
			writer.write("<table>");
			writer.write("<tr>");
			writer.write("<td colspan=3><h1>Location not found for "+locId+".</h1></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td>Location Id :</td>");
			writer.write("<td><input type='text' id='locId' name='locId' value =''></td>");
			writer.write("</tr>");
			writer.write("<tr>");
			writer.write("<td><input type='button'  class='button button2' onclick ='findLoc()' value='Search Location'/></td>");
			writer.write("<td><input type='button' class=\"button button2\" onclick='goHome()' value='Go Home'/></td>");
			writer.write("</tr>");
			writer.write("</form>");
			writer.write("</body>");
			writer.write("</html>");
		}
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
