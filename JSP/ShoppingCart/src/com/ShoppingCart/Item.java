package com.ShoppingCart;

import java.io.Serializable;

public class Item implements Serializable{
	
	private String name;
	private Integer quantity;
	private Double unitPrice;
	private Double itemPrice;
	
	
	public Item() {
		super();
	}


	public Item(String name, Integer quantity, Double unitPrice, Double itemPrice) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.itemPrice = itemPrice;
	}


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
		if(this.quantity != null && this.unitPrice != null){
			return  this.quantity * this.unitPrice;
		}
		return 0D;
	}


	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}


	@Override
	public String toString() {
		return "Items [name=" + name + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", itemPrice="
				+ itemPrice + "]";
	}


}