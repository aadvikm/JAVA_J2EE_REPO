package com.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitProduct extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}

	private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer penQuantity = Integer.parseInt(req.getParameter("penQuantity"));
		Integer penPrice = Integer.parseInt(req.getParameter("penPrice"));
		
		Integer pencilQuantity = Integer.parseInt(req.getParameter("pencilQuantity"));
		Integer pencilPrice = Integer.parseInt(req.getParameter("pencilPrice"));
		
		Integer eraserQuantity = Integer.parseInt(req.getParameter("eraserQuantity"));
		Integer eraserPrice = Integer.parseInt(req.getParameter("eraserPrice"));
		
		OrderDetail orderDetail = new OrderDetail();
		ArrayList<Product> productList = new ArrayList<Product>();
		Product pen= new Product();
		pen.setName("Pen");
		pen.setUnitPrice(Double.valueOf(penPrice));
		pen.setQuantity(penQuantity);
		pen.setItemPrice(Double.valueOf(penPrice*penQuantity));
		
		Product pencil= new Product();
		pencil.setName("Pencil");
		pencil.setUnitPrice(Double.valueOf(pencilPrice));
		pencil.setQuantity(pencilQuantity);
		pencil.setItemPrice(Double.valueOf(pencilPrice*pencilQuantity));
		
		Product eraser= new Product();
		eraser.setName("Eraser");
		eraser.setUnitPrice(Double.valueOf(eraserPrice));
		eraser.setQuantity(eraserQuantity);
		eraser.setItemPrice(Double.valueOf(eraserPrice*eraserQuantity));
		
		//Adding products in the list
		productList.add(pen);
		productList.add(pencil);
		productList.add(eraser);
		//Populate Order Detail
		orderDetail.setOrderDate(new Date());
		orderDetail.setProductList(productList);
		orderDetail.setOrderAmount(pen.getItemPrice()+pencil.getItemPrice()+eraser.getItemPrice());
		
		//Add user order detail to session
		req.getSession().setAttribute("orderDetail", orderDetail);
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		writer.write("<html><body>");
		writer.write("<form action='/ShoppingCart/placeOrder' method='post'>");
		writer.write("<h3>Hi "+req.getSession().getAttribute("username")+",</h3>");
		writer.write("<h3>Review Order</h3>");
		writer.write("<table style='width:50%'>");
		writer.write("<tr>");
		writer.write("<td><bold>Item<bold></td><td><bold>Quantity<bold></td><td><bold>Unit Price<bold></td><td><bold>Item Price<bold></td>");
		writer.write("</tr>");
		for(Product product : productList){
			writer.write("<tr>");
			writer.write("<td>"+product.getName()+"</td><td>"+product.getQuantity()+"</td><td>"+product.getUnitPrice()+"</td><td>"+product.getItemPrice()+"</td>");
			writer.write("</tr>");
		}
		writer.write("<tr>");
		writer.write("<td colspan='3' align='center'><bold>Total</bold></td><td>"+orderDetail.getOrderAmount()+"</td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td colspan='4' align='right'><input type='submit' value='Place Order'/></td>");
		writer.write("</tr>");
		writer.write("</table>");
		writer.write("</form>");
		writer.write("</body></html>");
		
		
	}

}
