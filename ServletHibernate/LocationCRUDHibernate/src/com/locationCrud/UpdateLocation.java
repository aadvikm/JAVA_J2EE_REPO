package com.locationCrud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateLocation extends HttpServlet {

	public UpdateLocation() {
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
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<meta charset=\"ISO-8859-1\">");
		writer.write("<title>Update Location Page</title>");
		writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mytheme.css\">");
		writer.write("</head>");
		writer.write("<script type='text/javascript' src='js/updatepage.js'></script>");
		writer.write("<body>");
		writer.write("<form id='updatepage' name='updatepage'>");
		writer.write("<img src='images/locimage.png' style='width:800px;height:150px;'>");
		writer.write("<h1>Welcome  "+username+",</h1><br/><br/>");
		writer.write("<table>");
		writer.write("<tr>");
		writer.write("<td>Location Id :</td>");
		writer.write("<td><input type='text' id='locId' name='locId' value =''></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td><input type='button'  class='button button2' onclick ='findLoc()' value='Search Location'/></td>");
		writer.write("<td><input type='button' class=\"button button2\" onclick='goHome()' value='Go Home'/></td>");
		writer.write("</tr>");
		writer.write("</form>");
		writer.write("</body>");
		writer.write("</html>");
	}
}
