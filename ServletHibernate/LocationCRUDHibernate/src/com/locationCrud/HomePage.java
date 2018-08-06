package com.locationCrud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomePage extends HttpServlet {

	public HomePage() {
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
			HttpSession session =req.getSession();
			String username =(String)session.getAttribute("username");
			resp.setContentType("text/html");
			PrintWriter writer=resp.getWriter();
			
			writer.write("<html>");writer.write("<html>");
			writer.write("<head>");
			writer.write("<meta charset=\"ISO-8859-1\">");
			writer.write("<title>Home Page</title>");
			writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
			writer.write("</head>");
			writer.write("<script type='text/javascript' src='js/homepage.js'></script>");
			writer.write("<body>");
			writer.write("<form id='homepage' name='homepage'>");
			writer.write("<img src='images/locimage.png' style='width:800px;height:150px;'>");
			writer.write("<h1>Welcome  "+username+",</h1><br/><br/>");
			writer.write("<input type='button' onclick='createLoc()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Create Location'/><br/>");
			writer.write("<input type='button' onclick='updateLoc()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Update Location'/><br/>");
			writer.write("<input type='button' onclick='deleteLoc()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Delete Location'/><br/>");
			writer.write("<input type='button' onclick='findLoc()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Find Location'/><br/>");
			writer.write("<input type='button' onclick='logout()' class='button button2' style='margin-top: 1px;margin-bottom: 1px;' value='Logout'/><br/>");
			writer.write("</form>");
			writer.write("</body>");
			writer.write("</html>");
	}

}
