package com.shoppingcartpractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlaceOrder extends HttpServlet {

	public PlaceOrder() {
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

	private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Object obj=req.getSession().getAttribute("orderDetail");
		OrderDetail orderD=(OrderDetail)obj;
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		writer.write("<html><body bgcolor='lightyellow'>");
		writer.write("<h3>Hi "+req.getSession().getAttribute("username")+ ",</h3>");
		writer.write("<form method='post' action='/ShoppingCartPractice/logoutServlet'>");
		writer.write("<h4>Your Order Confirmation Number is 1004500..!!</h4>");
		writer.write("<h4>Your order is placed for $ "+orderD.getOrderAmount()+ " and will be shipped soon..!!</h4>");
		writer.write("<h4>The product delivery date is  "+ addDays(orderD.getOrderDate(), 3)+"</h4>");
		writer.write("<input type='submit' value='Logout'/>");
		writer.write("</form>");
		writer.write("</body></html>");
		
	
	}
	
	public Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	}
	

}
