package com.school.hibernate;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CLASS")
@NamedQuery(name="gtAllClassDetails", query="select c from Class c")
public class Class implements Serializable{
	
	@Id
	@Column(name="CLASSID")
	@SequenceGenerator(name="classSeq", sequenceName="CLASS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "classSeq")
	private Integer classId;
	
	@Column(name="CLASSNAME")
	private String className;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="classId")
	private Set<ClassDetail> classDetail;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="classId")
	private Set<Student> student;
	
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<ClassDetail> getClassDetail() {
		return classDetail;
	}

	public void setClassDetail(Set<ClassDetail> classDetail) {
		this.classDetail = classDetail;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className + ", classDetail=" + classDetail + ", student="
				+ student + "]";
	}

	
	

}
