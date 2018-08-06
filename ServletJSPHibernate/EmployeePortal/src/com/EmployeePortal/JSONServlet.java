package com.EmployeePortal;

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
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JSONServlet extends HttpServlet{

	public JSONServlet() {
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
		
		Session hSession = getHibernateSession();
		Long offset = req.getParameter("offset") == null ? 1L : Long.parseLong(req.getParameter("offset"));
		Long limit = req.getParameter("limit") == null ? 5L : Long.parseLong(req.getParameter("limit"));
		HttpSession session = req.getSession();
		
		SQLQuery query = hSession.createSQLQuery(
				"select * from (select rownum as rank,  e.first_name||' '||e.last_name as empName, m.first_name||' '||m.last_name as mgrName, l.city as location, e.salary as salary, e.employee_id as id  from employees e, employees m, departments d, locations l   where e.manager_id=m.employee_id and d.department_id=e.department_id and  d.location_id=l.location_id  order by e.salary desc) where rank between :offset and :limit order by salary desc");
		query.setParameter("offset", offset);
		query.setParameter("limit", limit);
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		for (Object obj : query.list()) {
			Object[] objArr = (Object[]) obj;
			Employee empEntity = new Employee((String) objArr[1], (String) objArr[2], (String) objArr[3],
					(BigDecimal) objArr[4], ((BigDecimal)objArr[5]).longValue());
			employeeList.add(empEntity);
		}
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(employeeList));
		writer.write(mapper.writeValueAsString(employeeList));
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
