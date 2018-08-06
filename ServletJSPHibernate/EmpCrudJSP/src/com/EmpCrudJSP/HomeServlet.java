package com.EmpCrudJSP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {

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
		String uname = (String) session.getAttribute("uname");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<meta charset=\"ISO-8859-1\">");
		writer.write("<title>Emp CRUD Page</title>");
		writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
		writer.write("</head>");
		writer.write("<script type='text/javascript' src='js/empcrud.js'></script>");
		writer.write("<body>");
		writer.write("<form id='empCrudForm' name='empCrudForm'>");
		writer.write("<img src=\"img/emp_banner1.gif\" style='width:800px;height:150px;'>");
		writer.write("Welcome  "+uname+",<br/><br/>");
		writer.write("<input type='button' onclick='getEmpDetail()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Find Emp'/><br/>");
		writer.write("<input type='button' onclick='updateEmpDetail()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Update Emp'/><br/>");
		writer.write("<input type='button' onclick='deleteEmpDetail()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Delete Emp'/><br/>");
		writer.write("<input type='button' onclick='createEmpDetail()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Create Emp'/><br/>");
		writer.write("</form>");
		writer.write("</body>");
		writer.write("</html>");
	}

}
