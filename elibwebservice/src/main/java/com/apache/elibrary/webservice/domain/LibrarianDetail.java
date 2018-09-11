package com.apache.elibrary.webservice.domain;

import java.util.Date;

public class LibrarianDetail {
	private Long librarianId;
	private String librarianUserId;
	private String name;
	private String emailId;
	private Date dateOfBirth;
	private String mobileNo;
	private String password;
	
	public LibrarianDetail() {
		// TODO Auto-generated constructor stub
	}

	public LibrarianDetail(Long librarianId, String librarianUserId, String name, String emailId, Date dateOfBirth,
			String mobileNo, String password) {
		super();
		this.librarianId = librarianId;
		this.librarianUserId = librarianUserId;
		this.name = name;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.mobileNo = mobileNo;
		this.password = password;
	}
	
	public LibrarianDetail(LibrarianEntity librarianEntity){
		this(librarianEntity.getLibrarianId(), librarianEntity.getLibrarianUserId(), librarianEntity.getName(),
				librarianEntity.getEmailId(), librarianEntity.getDateOfBirth(), librarianEntity.getMobileNo(), librarianEntity.getPassword());
	}
	
	public LibrarianDetail(String librarianUserId, String name, String emailId, 
			String mobileNo, String password) {
		this.librarianUserId = librarianUserId;
		this.name = name;
		this.emailId = emailId;
		
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public Long getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(Long librarianId) {
		this.librarianId = librarianId;
	}

	public String getLibrarianUserId() {
		return librarianUserId;
	}

	public void setLibrarianUserId(String librarianUserId) {
		this.librarianUserId = librarianUserId;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	@Override
	public String toString() {
		return "LibrarianDetail [librarianId=" + librarianId + ", librarianUserId=" + librarianUserId + ", name=" + name
				+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", mobileNo=" + mobileNo + ", password="
				+ password + "]";
	}

}
