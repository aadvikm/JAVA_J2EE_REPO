package com.StationaryPurchase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitProduct extends HttpServlet{

	public SubmitProduct() {
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
		OrderDetails orderDetail = new OrderDetails();
		ArrayList<Item> items = new ArrayList<Item>();
		if(req.getParameter("checkbox1") != null && req.getParameter("checkbox1").equals("on")){
			Item pen = new Item();
			pen.setName("Pen");
			pen.setUnitPrice(30D);
			pen.setQuantity(Integer.parseInt(req.getParameter("penQuantity"))); 
			items.add(pen);
		}
		if(req.getParameter("checkbox2") != null && req.getParameter("checkbox2").equals("on")){
			Item pencil = new Item();
			pencil.setName("Pencil");
			pencil.setUnitPrice(25D);
			pencil.setQuantity(Integer.parseInt(req.getParameter("pencilQuantity"))); 
			items.add(pencil);	
		}
		if(req.getParameter("checkbox3") != null && req.getParameter("checkbox3").equals("on")){
			Item eraser = new Item();
			eraser.setName("Eraser");
			eraser.setUnitPrice(20D);
			eraser.setQuantity(Integer.parseInt(req.getParameter("eraserQuantity"))); 
			items.add(eraser);
		}
		Double totalOrderAmt = 0.00D;
		for(Item item : items){
			totalOrderAmt = totalOrderAmt + item.getItemPrice();
		}
		orderDetail.setOrderAmount(totalOrderAmt);
		orderDetail.setItemList(items);
		req.getSession().setAttribute("orderDetails", orderDetail);
		RequestDispatcher redispatcher =req.getRequestDispatcher("views/orderDetailPage.jsp");
		redispatcher.forward(req, resp);
	}
}
