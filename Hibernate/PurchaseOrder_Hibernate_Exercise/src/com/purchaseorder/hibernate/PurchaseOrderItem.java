package com.purchaseorder.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PURCHASEORDERITEM")
public class PurchaseOrderItem implements Serializable {
	
	@Id
	@Column(name="POITEMID")
	@SequenceGenerator(name="purchaseOrderItemSeq", sequenceName="PURCHASEORDERITEM_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "purchaseOrderItemSeq")
	private Integer poItemId;
	
	//@ManyToOne
	//@JoinColumn(name="PURCHASEID", nullable =true)
	//private PurchaseOrder purchaseId;
	
	@Column(name="PURCHASEID")
	private Integer purchaseId;
	
	@ManyToOne
	@JoinColumn(name="ITEMID", nullable =true)
	private Item itemId;
	
	//@Column(name="ITEMID")
	//private Integer itemId;
	
	@Column(name="QUANTITY")
	private Integer quantity;
	
	@Column(name="PRICE")
	private Integer price;
	
	public PurchaseOrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPoItemId() {
		return poItemId;
	}

	public void setPoItemId(Integer poItemId) {
		this.poItemId = poItemId;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	/*public PurchaseOrder getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(PurchaseOrder purchaseId) {
		this.purchaseId = purchaseId;
	}*/
	
	/*public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}*/
	
	public Item getItemId() {
		return itemId;
	}

	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PurchaseOrderItem [poItemId=" + poItemId + ", purchaseId=" + purchaseId + ", itemId=" + itemId
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}

	
	
	
	
	

}
