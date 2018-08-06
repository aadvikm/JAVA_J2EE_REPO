package com.StationaryPurchase;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoBackServlet extends HttpServlet{

	public GoBackServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderDetails orderDetail = (OrderDetails)req.getSession().getAttribute("orderDetails");
		for(Item item : orderDetail.getItemList()){
			if(item.getName().equalsIgnoreCase("Pen")){
				req.setAttribute("checkbox1", "on");
				req.setAttribute("penQuantity", item.getQuantity());
			}
			else if(item.getName().equalsIgnoreCase("Pencil")){
				req.setAttribute("checkbox2", "on");
				req.setAttribute("pencilQuantity", item.getQuantity());
			}
			else if(item.getName().equalsIgnoreCase("Eraser")){
				req.setAttribute("checkbox3", "on");
				req.setAttribute("eraserQuantity", item.getQuantity());
			}
		}
		RequestDispatcher redispatcher =req.getRequestDispatcher("/views/productpage.jsp");
		redispatcher.forward(req, resp);
	}
}
