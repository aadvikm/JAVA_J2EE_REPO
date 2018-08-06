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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMERS")
public class Customer implements Serializable{
	
	@Id
	@Column(name="CUSTOMERID")
	@SequenceGenerator(name="customerSeq", sequenceName="CUSTOMERS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "customerSeq")
	private Integer customerId;
	
	@Column(name="CUSTOMERNAME")
	private String customerName;
	
	@Column(name="CUSTOMERPHONENO")
	private String customerPhoneNo;
	
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="customerId")
	//private Set<PurchaseOrder> purchaseOrder;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}


	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhoneNo="
				+ customerPhoneNo + "]";
	}


	/*public Set<PurchaseOrder> getPurchaseOrder() {
		return purchaseOrder;
	}


	public void setPurchaseOrder(Set<PurchaseOrder> purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}*/


	

	
	

}
