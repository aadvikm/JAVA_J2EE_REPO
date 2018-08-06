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

public class DeletedLocationPage extends HttpServlet{

	public DeletedLocationPage() {
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
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String locId =req.getParameter("locId");
		LocationEntity locEntity=null;
		Transaction tx =hsession.beginTransaction();
		locEntity = (LocationEntity)hsession.get(LocationEntity.class, Integer.parseInt(locId));
		
		if(locEntity!=null){
			
			hsession.delete(locEntity);
			tx.commit();
			System.out.println("Deleted Successfully..!!!!!");
			
			req.setAttribute("locationEntity", locEntity);
			
			
		}
		RequestDispatcher redispatcher =req.getRequestDispatcher("views/deletedPage.jsp");
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
