package com.StationaryPurchase;

import java.io.Serializable;
import java.util.List;

public class OrderDetails implements Serializable{
	
	private List<Item> itemList;
	private Double orderAmount;
	
	public OrderDetails() {
		super();
	}

	public OrderDetails(List<Item> itemList, Double orderAmount) {
		super();
		this.itemList = itemList;
		this.orderAmount = orderAmount;
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

	@Override
	public String toString() {
		return "OrderDetails [itemList=" + itemList + ", orderAmount=" + orderAmount + "]";
	}
	
	
}
