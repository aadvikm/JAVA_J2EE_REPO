package com.deptcrud.dropdown;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class FindDept extends HttpServlet {

	public FindDept() {
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
		String action = req.getParameter("action");
		 
		if(action.equals("loadFindPage")){
			//ToDo..!!
		}
		else if(action.equals("searchedPage")){
			String deptId =req.getParameter("deptId");
			Session hSession = getHibernateSession();
			DepartmentEntity deptEntity =(DepartmentEntity)hSession.get(DepartmentEntity.class, new Integer(deptId));
			//loading...
			SQLQuery query = hSession.createSQLQuery("select first_name||' '||last_name from employees where employee_id = "+deptEntity.getManagerId());
			for(Object object :  query.list()){
				deptEntity.setManagerName((String)object); 
			}
			query = hSession.createSQLQuery("select STREET_ADDRESS from locations where location_id = "+deptEntity.getLocationId());
			for(Object object :  query.list()){
				deptEntity.setStreetAddress((String)object);
			}
			req.setAttribute("findDeptSuccess", "Department Id  "+deptId+" details are.,");
			req.setAttribute("deptEntity", deptEntity);
		}
		RequestDispatcher reqDispatcher =req.getRequestDispatcher("views/findpage.jsp");
		reqDispatcher.forward(req, resp);
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
