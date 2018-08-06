package com.ShoppingCart;

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
	
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		OrderDetail orderDetail = new OrderDetail();
		ArrayList<Item> items = new ArrayList<Item>();
		
		if(req.getParameter("checkbox1") != null && req.getParameter("checkbox1").equals("on")){
			Item oilPaints = new Item();
			oilPaints.setName("OilPaints");
			oilPaints.setUnitPrice(30D);
			oilPaints.setQuantity(Integer.parseInt(req.getParameter("oilPaintsQuantity"))); 
			items.add(oilPaints);
		}
		if(req.getParameter("checkbox2") != null && req.getParameter("checkbox2").equals("on")){
			Item colorPencil = new Item();
			colorPencil.setName("ColorPencil");
			colorPencil.setUnitPrice(25D);
			colorPencil.setQuantity(Integer.parseInt(req.getParameter("colorPencilQuantity"))); 
			items.add(colorPencil);	
		}
		if(req.getParameter("checkbox3") != null && req.getParameter("checkbox3").equals("on")){
			Item crayons = new Item();
			crayons.setName("Crayons");
			crayons.setUnitPrice(20D);
			crayons.setQuantity(Integer.parseInt(req.getParameter("crayonsQuantity"))); 
			items.add(crayons);
		}
		Double totalOrderAmt = 0.00D;
		for(Item item : items){
			totalOrderAmt = totalOrderAmt + item.getItemPrice();
		}
		
		orderDetail.setOrderAmount(totalOrderAmt);
		orderDetail.setItemList(items);
		orderDetail.setOrderDate(new Date());
		req.getSession().setAttribute("orderDetail", orderDetail);
		RequestDispatcher redispatcher =req.getRequestDispatcher("views/orderdetailpage.jsp");
		redispatcher.forward(req, resp);
	}

}
