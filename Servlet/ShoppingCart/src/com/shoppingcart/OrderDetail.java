package com.shoppingcart;

import java.util.Date;
import java.util.List;

public class OrderDetail {

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	private Integer orderNo;
	private Date orderDate;
	private List<Product> productList;
	private Double orderAmount;
	
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
}
