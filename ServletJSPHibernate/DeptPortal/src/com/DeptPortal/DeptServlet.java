package com.DeptPortal;

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

public class DeptServlet extends HttpServlet{

	public DeptServlet() {
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
		
		Long offset = req.getParameter("offset") == null ? 1L : Long.parseLong(req.getParameter("offset"));
		Long limit = req.getParameter("limit") == null ? 3L : Long.parseLong(req.getParameter("limit"));
		
		HttpSession session = req.getSession();
		Session hsession = getHibernateSession();
		
		SQLQuery query = hsession.createSQLQuery("Select *  from (Select rownum as rank, department_id as deptId, "
				+ "department_name as deptName, location_id as locationId, manager_id as managerId"
				+ " from departments) where rank between "+offset+ "and "+limit);
	
		
		ArrayList<Department> deptList = new ArrayList<Department>();
		for (Object obj : query.list()) {
			Object[] objArr = (Object[]) obj;
			Department deptEntity = new Department(((BigDecimal) objArr[1]).intValue(), (String) objArr[2], ((BigDecimal) objArr[3]).intValue(),
					objArr[4] != null ? ((BigDecimal) objArr[4]).longValue() : null);
			deptList.add(deptEntity);
		}
		req.setAttribute("deptList", deptList);
		
		req.setAttribute("p_offset", offset == 1 ? 1L :offset-3);
		req.setAttribute("p_limit", limit == 3 ? 3L : limit-3);
		
		req.setAttribute("offset", offset);
		req.setAttribute("limit", limit);
		
		req.setAttribute("n_offset", offset+3);
		req.setAttribute("n_limit", limit+3);
		RequestDispatcher reqDispatcher = req.getRequestDispatcher("views/dept.jsp");
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
