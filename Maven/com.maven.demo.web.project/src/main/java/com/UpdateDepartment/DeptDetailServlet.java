package com.UpdateDepartment;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DeptDetailServlet extends HttpServlet {

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
		
		String deptId =req.getParameter("deptId");
		
		DeptDetail deptDetail =new DeptDetail();
		deptDetail.setDeptId(Long.parseLong(deptId));
		
		Query query =hsession.createSQLQuery("Select department_name as deptName, manager_id as mgrId, location_id as locId from departments where department_id ="+deptId);
		for(Object obj :query.list()){
			Object[] objArr =(Object[]) obj;
			deptDetail.setDeptName((String)objArr[0]);
			deptDetail.setMgrId(((BigDecimal)objArr[1]).longValue());
			deptDetail.setLocId(((BigDecimal)objArr[2]).longValue());

		}
		
		SQLQuery query1 =hsession.createSQLQuery("Select employee_id as mgrId, (first_name||' '||last_name) as mgrName from employees e where employee_id in(select manager_id from employees)");
		ArrayList<Employee> mgrList =new ArrayList<Employee>();
		for(Object obj : query1.list()){
			Object[] objArr = (Object[]) obj;
			Employee mgr =new Employee(((BigDecimal)objArr[0]).longValue(), (String)objArr[1]);
			mgrList.add(mgr);
		}
		deptDetail.setMgrList(mgrList);
		
		SQLQuery query2 =hsession.createSQLQuery("Select location_id as locId, city as city from locations");
		ArrayList<Location> locList =new ArrayList<Location>();
		for(Object obj : query2.list()){
			Object[] objArr = (Object[]) obj;
			Location loc =new Location(((BigDecimal)objArr[0]).longValue(), (String)objArr[1]);
			locList.add(loc);
		}
		deptDetail.setLocList(locList);
		
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(deptDetail));
		writer.write(mapper.writeValueAsString(deptDetail));
		
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
