package com.ShoppingCart;

import java.util.Date;
import java.util.List;

public class OrderDetail {
	
	private List<Item> itemList;
	private Double orderAmount;
	private Date orderDate;
	
	public OrderDetail() {
		super();
	}

	public OrderDetail(List<Item> itemList, Double orderAmount, Date orderDate) {
		super();
		this.itemList = itemList;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderDetail [itemList=" + itemList + ", orderAmount=" + orderAmount + ", orderDate=" + orderDate + "]";
	}
	

}
