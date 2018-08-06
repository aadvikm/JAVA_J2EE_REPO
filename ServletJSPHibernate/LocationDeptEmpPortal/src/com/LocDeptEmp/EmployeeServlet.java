package com.LocDeptEmp;

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
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class EmployeeServlet extends HttpServlet{

	public EmployeeServlet() {
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
		String locId =req.getParameter("locId");
		String deptId =req.getParameter("deptId");
		
		HttpSession session = req.getSession();
		Session hsession = getHibernateSession();
		
		SQLQuery query =hsession.createSQLQuery("Select e.employee_id as emp_id, (e.first_name||' '||e.last_name) as empName from employees e, departments d, locations l where e.department_id =d.department_id and d.location_id =l.location_id and d.department_id =:deptId and l.location_id =:locId");
		query.setParameter("deptId", deptId);
		query.setParameter("locId", locId);
		
		ArrayList<Employee> empList =new ArrayList<Employee>();
		for(Object obj :query.list()){
			Object [] empObj =(Object[])obj;
			Employee empEntity =new Employee(((BigDecimal)empObj[0]).longValue(),(String)empObj[1]);
			empList.add(empEntity);
			
		}
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(empList));
		writer.write(mapper.writeValueAsString(empList));
		
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
