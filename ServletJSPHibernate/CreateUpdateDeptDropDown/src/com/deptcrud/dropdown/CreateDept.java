package com.deptcrud.dropdown;

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
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CreateDept extends HttpServlet{

	public CreateDept() {
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
		String action =req.getParameter("action");
		if(action.equals("loadCreatePage")){
			Session hsession =getHibernateSession();
			SQLQuery query =hsession.createSQLQuery("Select employee_id, first_name||' '||last_name from employees e where exists(select * from employees where manager_id=e.employee_id)");
			ArrayList<Manager> managerList =new ArrayList<Manager>();
			for(Object obj : query.list()){
				Object[] objArr=(Object[])obj;
				managerList.add(new Manager(((BigDecimal)objArr[0]).longValue(), (String)objArr[1]));
			}
			req.setAttribute("managerList", managerList);
			query = hsession.createSQLQuery("select location_id, STREET_ADDRESS from locations");
			ArrayList<Location> locationList = new ArrayList<Location>();
			for(Object object :  query.list()){
				Object[] objArr = (Object[])object;
				locationList.add(new Location(((BigDecimal)objArr[0]).longValue(), (String)objArr[1]));
			}
			req.setAttribute("locationList", locationList);
		} 
		else if(action.equals("getLocationManagers")){
			Session hsession=getHibernateSession();
			StringBuffer sb = new StringBuffer();
			sb.append("select e.employee_id, first_name||' '||last_name from employees e, departments d, locations l");
			sb.append(" where e.department_id = d.department_id");
			sb.append(" and d.location_id = l.location_id");
			sb.append(" and exists (select * from employees where manager_id = e.employee_id)");
			sb.append(" and l.location_id = "+req.getParameter("locationId"));
			SQLQuery query = hsession.createSQLQuery(sb.toString());
			ArrayList<Manager> managerList = new ArrayList<Manager>();
			for(Object object :  query.list()){
				Object[] objArr = (Object[])object;
				managerList.add(new Manager(((BigDecimal)objArr[0]).longValue(), (String)objArr[1]));
			}
			req.setAttribute("managerList", managerList);
			query = hsession.createSQLQuery("select location_id, STREET_ADDRESS from locations");
			ArrayList<Location> locationList = new ArrayList<Location>();
			for(Object object :  query.list()){
				Object[] objArr = (Object[])object;
				locationList.add(new Location(((BigDecimal)objArr[0]).longValue(), (String)objArr[1]));
			}
			req.setAttribute("locationList", locationList);

		}
		else if(action.equals("newDeptPage")){
			String deptName =req.getParameter("deptName");
			String managerId =req.getParameter("managerId");
			String locationId =req.getParameter("locationId");
			HttpSession session =req.getSession();
			String username =(String)session.getAttribute("username");
			
			DepartmentEntity deptEntity=new DepartmentEntity();
			deptEntity.setDeptName(deptName);
			deptEntity.setLocationId(locationId == null ?null : Integer.parseInt(locationId));
			deptEntity.setManagerId(new Long(managerId) ==null ?null :new Long(managerId));
			
			Session hsession=getHibernateSession();
			Transaction tx =hsession.beginTransaction();
			hsession.persist(deptEntity);
			tx.commit();
			System.out.println("Committed Successfully..!!");
			req.setAttribute("createDeptSuccess", "You are successfully created a new department "+deptEntity.getDeptId()+".!!");
			req.setAttribute("deptEntity", deptEntity);
		}
		RequestDispatcher reqDispatcher =req.getRequestDispatcher("views/createpage.jsp");
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
