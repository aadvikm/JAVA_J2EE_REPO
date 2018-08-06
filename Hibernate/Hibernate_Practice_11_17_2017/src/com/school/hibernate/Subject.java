package com.school.hibernate;

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
@Table(name="SUBJECT")
public class Subject implements Serializable{
	
	@Id
	@Column(name="SUBJECTID")
	@SequenceGenerator(name="subjectSeq", sequenceName="SUBJECT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "subjectSeq")
	private Integer subjectId;
	
	@Column(name="SUBJECTNAME")
	private String subjectName;
	
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="subjectId")
	// Set<ClassDetail> classDetail;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}


	public String getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}


	/*public Set<ClassDetail> getClassDetail() {
		return classDetail;
	}


	public void setClassDetail(Set<ClassDetail> classDetail) {
		this.classDetail = classDetail;
	}*/





}
