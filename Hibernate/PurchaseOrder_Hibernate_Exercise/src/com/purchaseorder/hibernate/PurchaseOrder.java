package com.purchaseorder.hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PURCHASEORDER")
@NamedQuery(name="getAllPO", query ="select p from PurchaseOrder p")
public class PurchaseOrder implements Serializable{
	
	@Id
	@Column(name="PURCHASEID")
	@SequenceGenerator(name="purchaseOrderSeq", sequenceName="PURCHASEORDER_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "purchaseOrderSeq")
	private Integer purchaseId;
	
	@Column(name="PURCHASEDATE")
	private Date purchaseDate;
	
	@Column(name="TOTALPOAMOUNT")
	private Integer totalPOAmount;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMERID", nullable =true)
	private Customer customerId;
	
	
	//@Column(name="CUSTOMERID")
	//private Integer customerId;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="purchaseId")
	private Set<PurchaseOrderItem> poItem;
	
	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getTotalPOAmount() {
		return totalPOAmount;
	}

	public void setTotalPOAmount(Integer totalPOAmount) {
		this.totalPOAmount = totalPOAmount;
	}

	/*public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}*/


	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	
	public Set<PurchaseOrderItem> getPoItem() {
		return poItem;
	}


	public void setPoItem(Set<PurchaseOrderItem> poItem) {
		this.poItem = poItem;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseId=" + purchaseId + ", purchaseDate=" + purchaseDate + ", totalPOAmount="
				+ totalPOAmount + ", customerId=" + customerId + ", poItem=" + poItem + "]";
	}


	

	
	

}
