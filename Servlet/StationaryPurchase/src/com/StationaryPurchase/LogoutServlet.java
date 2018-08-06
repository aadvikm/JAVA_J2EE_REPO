package com.StationaryPurchase;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		System.out.println("The unique session id in next servlet : "+session.getId());
		if(session != null){
			System.out.println("Invalidating session...");
			session.invalidate();
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.html");
		requestDispatcher.forward(req, resp);
	}

	

}
