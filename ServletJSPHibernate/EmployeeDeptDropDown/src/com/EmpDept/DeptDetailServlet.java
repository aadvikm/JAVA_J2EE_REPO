package com.EmpDept;

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

public class DeptDetailServlet extends HttpServlet{

	public DeptDetailServlet() {
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
		
		SQLQuery query =hsession.createSQLQuery("Select Department_id as deptId, department_name as deptName, manager_id as mgrId from Departments");
		ArrayList<Department> deptList =new ArrayList<Department>();

		for (Object obj : query.list()) {
			Object[] objArr = (Object[]) obj;
			Department deptEntity =new Department(((BigDecimal)objArr[0]).longValue(), ((String)objArr[1]), ((BigDecimal)objArr[2]) !=null ? ((BigDecimal)objArr[2]).longValue() : null );
			deptList.add(deptEntity);
		}
		
		req.setAttribute("DeptList", deptList);
		
		
		RequestDispatcher reqDispatcher = req.getRequestDispatcher("views/empDept.jsp");
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
