package com.jspDeptCrud;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class DeleteDept extends HttpServlet{

	public DeleteDept() {
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
		
		if(action.equals("loadDeletePage")){
			//ToDo..
		}
		else if(action.equals("searchedPage")){
			String deptId =req.getParameter("deptId");
			Session hSession = getHibernateSession();
			DepartmentEntity deptEntity =(DepartmentEntity)hSession.get(DepartmentEntity.class, new Integer(deptId));
			if(deptEntity !=null){
				req.setAttribute("deptEntity", deptEntity);
			}
		}
		else if(action.equals("deletedPage")){
			String deptId =req.getParameter("deptId");
			Session hsession = getHibernateSession();
			DepartmentEntity deptEntity =null;
			Transaction tx =hsession.beginTransaction();
			deptEntity=(DepartmentEntity)hsession.get(DepartmentEntity.class, Integer.parseInt(deptId));
			if(deptEntity !=null){
				hsession.delete(deptEntity);
				tx.commit();
				System.out.println("Deleted Successfully..!!!!!");
				req.setAttribute("successMsg", "The department Id "+deptId+" has been deleted successfully!!!");
				req.setAttribute("deptEntity", deptEntity);
			}
		}
		RequestDispatcher reqDispatcher =req.getRequestDispatcher("views/deletepage.jsp");
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
