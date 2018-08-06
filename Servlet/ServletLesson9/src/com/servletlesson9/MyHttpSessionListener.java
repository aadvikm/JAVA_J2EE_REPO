package com.servletlesson9;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
	 
	

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("Session is created....");
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		if(context.getAttribute("totNoOfUserLoggedIn") == null){
			context.setAttribute("totNoOfUserLoggedIn", 1);
			context.setAttribute("currentActiveNoOfUser", 1);
		}
		else{
			int totNoOfUserLoggedIn = (Integer) context.getAttribute("totNoOfUserLoggedIn");
			totNoOfUserLoggedIn++;
			context.setAttribute("totNoOfUserLoggedIn", totNoOfUserLoggedIn);
			int currentActiveNoOfUser = (Integer) context.getAttribute("currentActiveNoOfUser");
			currentActiveNoOfUser++;
			context.setAttribute("currentActiveNoOfUser", currentActiveNoOfUser);
		}
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("Session is invalidated....");
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		if(context.getAttribute("totNoOfUserLoggedIn") != null){
			int totNoOfUserLoggedIn = (Integer) context.getAttribute("totNoOfUserLoggedIn");
			totNoOfUserLoggedIn--;
			context.setAttribute("currentActiveNoOfUser", totNoOfUserLoggedIn);
		}
		
	}

}
