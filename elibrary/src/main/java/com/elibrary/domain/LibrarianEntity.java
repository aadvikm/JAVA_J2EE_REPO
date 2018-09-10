package com.elibrary.domain;

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
@Table(name="LIBRARIAN")
@NamedQueries({ @NamedQuery(name = "LibrarianEntity.getAllLibrarianEntities", 
							query ="Select le from LibrarianEntity le"), 
				@NamedQuery(name="LibrarianEntity.getLibrarianByUserId", 
							query="Select le from LibrarianEntity le where le.librarianUserId = :paramLibrarianUserId")})
public class LibrarianEntity {
	@Id
	@Column(name = "LIBRARIAN_ID")
	@SequenceGenerator(name = "librarianSeqGen", sequenceName = "LIBRARIAN_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "librarianSeqGen", strategy = GenerationType.SEQUENCE)
	private Long librarianId;
	
	@Column(name="LIBRARIAN_USER_ID")
	private String librarianUserId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="DOB")
	private Date dateOfBirth;
	
	@Column(name="MOBILE")
	private String mobileNo;
	
	@Column(name="PASSWORD")
	private String password;
	
	public LibrarianEntity() {
		// TODO Auto-generated constructor stub
	}

	public LibrarianEntity(Long librarianId, String librarianUserId, String name, String emailId, Date dateOfBirth,
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
		return "LibrarianEntity [librarianId=" + librarianId + ", librarianUserId=" + librarianUserId + ", name=" + name
				+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", mobileNo=" + mobileNo + ", password="
				+ password + "]";
	}

}
