package com.school.hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student implements Serializable {
	
	@Id
	@Column(name="STUDENTID")
	@SequenceGenerator(name="studentSeq", sequenceName="STUDENT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "studentSeq")
	private Integer studentId;
	
	@Column(name="STUDENTNAME")
	private String studentName;
	
	@Column(name="SDOB")
	private Date sDOB;
	
	@Column(name="CLASSID")
	private Integer classId;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getsDOB() {
		return sDOB;
	}

	public void setsDOB(Date sDOB) {
		this.sDOB = sDOB;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", sDOB=" + sDOB + ", classId="
				+ classId + "]";
	}
	
	
	

}
