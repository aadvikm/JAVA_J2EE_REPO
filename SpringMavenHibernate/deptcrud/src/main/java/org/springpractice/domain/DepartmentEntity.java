package org.springpractice.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "DEPARTMENT_ID")
	@SequenceGenerator(name = "departmentSeqGen", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "departmentSeqGen", strategy = GenerationType.SEQUENCE)
	private Long deptId;
	@Column(name = "DEPARTMENT_NAME")
	private String deptName;
	@Column(name = "MANAGER_ID")
	private Long mgrId;
	@Column(name = "LOCATION_ID")
	private Long locId;

	public DepartmentEntity() {
	}

	public DepartmentEntity(Long deptId, String deptName, Long mgrId, Long locId) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.mgrId = mgrId;
		this.locId = locId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getMgrId() {
		return mgrId;
	}

	public void setMgrId(Long mgrId) {
		this.mgrId = mgrId;
	}

	public Long getLocId() {
		return locId;
	}

	public void setLocId(Long locId) {
		this.locId = locId;
	}

	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", deptName=" + deptName + ", mgrId=" + mgrId + ", locId=" + locId
				+ "]";
	}
}
