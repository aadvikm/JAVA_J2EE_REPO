package com.DeptPortal;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class DeptDetail
 */
@WebServlet("/DeptDetail")
public class DeptDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
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
		response.setContentType("text/plain");
		 PrintWriter out = response.getWriter();
		
		 for(Department dept : deptList){
			 out.write("<tr>");
			 out.write("<td align ='center'> <input type='checkbox' id='checkbox_"+ dept.getDeptId() +"' name ='checkbox' /></td>");
			 out.write("<td align ='center'> "+ dept.getDeptId() +"</td>");
			 out.write("<td align ='center'>"+ dept.getDeptName() +"</td>");
			 out.write("<td align ='center'>"+ dept.getLocationId() +"</td>");
			 out.write("<td align ='left'> "+ dept.getManagerId() +"</td>");
			 out.write("</tr>");
		 }
		 out.write("<tr nowrap=''><td colspan='5' align='right'><input type='button' style='width:80px' onclick='loadDepts("+(offset-3)+","+(limit-3)+")' value='Prev'>"+offset+"-"+limit+"<input type='button' style='width:80px' onclick='loadDepts("+(offset+3)+","+(limit+3)+")' value='Next'></td></tr>");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
