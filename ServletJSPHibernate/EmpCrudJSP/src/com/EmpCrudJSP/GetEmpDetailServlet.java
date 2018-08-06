package com.EmpCrudJSP;

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
import org.hibernate.cfg.Configuration;

public class GetEmpDetailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String uname = (String) session.getAttribute("uname");
		String empId = req.getParameter("empId");
		Session hSession = getHibernateSession();
		Employee employee = (Employee) hSession.get(Employee.class, new Long(empId));
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if(employee != null){
			req.setAttribute("employee", employee);
		}
		RequestDispatcher reqDispatcher = req.getRequestDispatcher("empdetail");
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
