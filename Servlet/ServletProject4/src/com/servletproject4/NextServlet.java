package com.servletproject4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NextServlet extends HttpServlet{

	public NextServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookieArr = req.getCookies();
		System.out.println("The lenght of cookie : "+cookieArr.length);
		PrintWriter printWriter = resp.getWriter();
		Cookie cookie = null;
		for(Cookie nCookie : cookieArr){
			System.out.println("tCookie.getName()  "+nCookie.getName());
			if(nCookie.getName().equals("user")){
				cookie = nCookie;
			}
		}
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		printWriter.write("<html><body>");
		printWriter.write("Hello "+cookie.getValue()+",");
		printWriter.write("<form method='get' action='/ServletProject4/LogoutServlet'>");
		printWriter.write("<h1>Hi now you're in Page 2.....</h1>");
		printWriter.write("<input type='submit' value='Logout'/>");
		printWriter.write("</form>");
		printWriter.write("</body></html>");
		
	}


}
