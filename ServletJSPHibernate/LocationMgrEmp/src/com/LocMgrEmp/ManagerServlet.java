package com.LocMgrEmp;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class ManagerServlet extends HttpServlet{

	public ManagerServlet() {
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
		String locId =req.getParameter("locId");
		
		SQLQuery query =hsession.createSQLQuery("Select Department_id as deptId, Manager_id as mgrId, Department_name as depName from Departments where manager_id is not null and location_id ="+locId);
		
		ArrayList<DepartmentMgr> mgrList =new ArrayList<DepartmentMgr>();
		
		for (Object obj : query.list()) {
			Object[] objArr = (Object[]) obj;
			DepartmentMgr deptMgr =new DepartmentMgr(((BigDecimal)objArr[0]).longValue(), (objArr[1] != null ? ((BigDecimal)objArr[1]).longValue() :null ), (String)objArr[2]);
			mgrList.add(deptMgr);
		}
		req.setAttribute("mgrList", mgrList);
		req.setAttribute("locId", locId);

		RequestDispatcher reqDispatcher = req.getRequestDispatcher("views/mgrEmpPage.jsp");
		reqDispatcher.forward(req, resp);

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
