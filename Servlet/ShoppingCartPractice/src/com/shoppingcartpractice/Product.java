package com.shoppingcartpractice;

public class Product {

	public Product() {
		// TODO Auto-generated constructor stub
	}

	private String name;
	private Integer quantity;
	private Double unitPrice;
	private Double itemPrice;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", itemPrice="
				+ itemPrice + "]";
	}
		
}
