package com.school.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CLASSDETAIL")
public class ClassDetail implements Serializable {
	
	@Id
	@Column(name="DETAILID")
	@SequenceGenerator(name="classDetailSeq", sequenceName="CLASSDETAIL_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "classDetailSeq")
	private Integer detailId;
	
	//@ManyToOne
	//@JoinColumn(name="SUBJECTID", nullable =true)
	//private Subject subjectId;
	
	@Column(name="SUBJECTID")
	private Integer subjectId;
	
	@ManyToOne
	@JoinColumn(name="TEACHERID", nullable =true)
	private Teacher teacherId;
	
	//@Column(name="TEACHERID")
	//private Integer teacherId;
	
	@Column(name="CLASSID")
	private Integer classId;
	
	//@ManyToOne
	//@JoinColumn(name="CLASSID", nullable =true)
	//private Class classId;
	
	public ClassDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDetailId() {
		return detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	/*public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}*/

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	
	/*public Subject getSubjectId() {
		return subjectId;
	}
	
	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}*/

	/*public Class getClassId() {
		return classId;
	}

	public void setClassId(Class classId) {
		this.classId = classId;
	}*/

	

	public Teacher getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Teacher teacherId) {
		this.teacherId = teacherId;
	}

	

	@Override
	public String toString() {
		return "ClassDetail [detailId=" + detailId + ", subjectId=" + subjectId + ", teacherId=" + teacherId
				+ ", classId=" + classId + "]";
	}


	
	

}
