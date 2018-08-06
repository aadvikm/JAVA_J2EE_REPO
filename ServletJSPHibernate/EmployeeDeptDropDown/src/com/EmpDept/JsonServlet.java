package com.EmpDept;

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

public class JsonServlet extends HttpServlet{

	public JsonServlet() {
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
		
		SQLQuery query =hsession.createSQLQuery("Select (first_name||' '||last_name) as empName, manager_id as mgrId, salary as salary, employee_id as empId from employees where department_id ="+deptId);
		
		ArrayList<Employee> empList =new ArrayList<Employee>();
		for(Object obj :query.list()){
			Object [] empObj =(Object[])obj;
			Employee empEntity =new Employee((String)empObj[0],((BigDecimal)empObj[1]).longValue(), (BigDecimal)empObj[2],((BigDecimal)empObj[3]).longValue());
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
