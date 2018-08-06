package com.purchaseorder.hibernate;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ITEMS")
public class Item implements Serializable {
	
	@Id
	@Column(name="ITEMID")
	@SequenceGenerator(name="itemSeq", sequenceName="ITEMS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "itemSeq")
	private Integer itemId;
	
	@Column(name="ITEMNAME")
	private String itemName;
	
	@Column(name="ITEMPRICE")
	private Integer itemPrice;
	
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="itemId")
	//private Set<PurchaseOrderItem> poItemId;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	

	/*public Set<PurchaseOrderItem> getPoItemId() {
		return poItemId;
	}

	public void setPoItemId(Set<PurchaseOrderItem> poItemId) {
		this.poItemId = poItemId;
	}*/

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}
	
	
	
	

}
