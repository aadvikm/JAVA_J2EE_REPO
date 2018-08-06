package com.jspDeptCrud;

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
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UpdateDept extends HttpServlet {

	public UpdateDept() {
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
		
		if(action.equals("loadUpdatePage")){
			//ToDo
		}
		else if(action.equals("searchedPage")){
			String deptId =req.getParameter("deptId");
			Session hSession = getHibernateSession();
			DepartmentEntity deptEntity =(DepartmentEntity)hSession.get(DepartmentEntity.class, new Integer(deptId));
			if(deptEntity != null){
				req.setAttribute("deptEntity", deptEntity);
			}
			
			SQLQuery query = hSession.createSQLQuery("select employee_id, first_name||' '||last_name from employees e where exists (select * from employees where manager_id = e.employee_id)");
			ArrayList<Manager> managerList = new ArrayList<Manager>();
			for(Object object :  query.list()){
				Object[] objArr = (Object[])object;
				managerList.add(new Manager(((BigDecimal)objArr[0]).longValue(), (String)objArr[1]));
			}
			req.setAttribute("managerList", managerList);
			query = hSession.createSQLQuery("select location_id, STREET_ADDRESS from locations");
			ArrayList<Location> locationList = new ArrayList<Location>();
			for(Object object :  query.list()){
				Object[] objArr = (Object[])object;
				locationList.add(new Location(((BigDecimal)objArr[0]).longValue(), (String)objArr[1]));
			}
			req.setAttribute("locationList", locationList);
		
		}
		else if(action.equals("updatedPage")){
			String deptId =req.getParameter("deptId");
			String deptName =req.getParameter("deptName");
			String managerId =req.getParameter("managerId");
			String locationId =req.getParameter("locationId");
			Session hsession = getHibernateSession();
			
			DepartmentEntity deptEntity =null;
			Transaction tx =hsession.beginTransaction();
			deptEntity=(DepartmentEntity)hsession.get(DepartmentEntity.class, Integer.parseInt(deptId));
			if(deptEntity !=null){
				deptEntity.setDeptName(deptName);
				deptEntity.setLocationId(locationId ==null? null : Integer.parseInt(locationId));
				deptEntity.setManagerId(managerId==null? null : new Long(managerId));
				hsession.update(deptEntity);
				tx.commit();
				System.out.println("Updated Successfully..!!!!!");
				req.setAttribute("successMsg", "The department Id "+deptId+" has been updated successfully!!!");
				req.setAttribute("deptEntity", deptEntity);
			}
		}
		RequestDispatcher reqDispatcher =req.getRequestDispatcher("views/updatepage.jsp");
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
