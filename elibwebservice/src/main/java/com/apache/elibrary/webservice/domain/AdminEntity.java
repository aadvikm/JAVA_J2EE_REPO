package com.apache.elibrary.webservice.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="ADMIN")
@NamedQueries({ @NamedQuery(name = "getAdminEntityByUserId", query = "select ae from AdminEntity ae where ae.adminUserId=:paramAdminUserId") })
public class AdminEntity {
	@Id
	@Column(name = "ADMIN_ID")
	@SequenceGenerator(name = "adminSeqGen", sequenceName = "ADMIN_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "adminSeqGen", strategy = GenerationType.SEQUENCE)
	private Long adminId;
	
	@Column(name="ADMIN_USER_ID")
	private String adminUserId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name ="EMAIL_ID")
	private String emailId;
	
	@Column(name="MOBILE")
	private String mobileNo;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="DOB")
	private Date dateOfBirth;
	
	
	public AdminEntity() {
		super();
	}


	public AdminEntity(Long adminId, String adminUserId, String name, String emailId, String mobileNo, String password,
			Date dateOfBirth) {
		super();
		this.adminId = adminId;
		this.adminUserId = adminUserId;
		this.name = name;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}


	public Long getAdminId() {
		return adminId;
	}


	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}


	public String getAdminUserId() {
		return adminUserId;
	}


	public void setAdminUserId(String adminUserId) {
		this.adminUserId = adminUserId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	@Override
	public String toString() {
		return "AdminEntity [adminId=" + adminId + ", adminUserId=" + adminUserId + ", name=" + name + ", emailId="
				+ emailId + ", mobileNo=" + mobileNo + ", password=" + password + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	

}
