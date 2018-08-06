import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DepartmentEntity {
	
	private Integer deptId;
	private String deptName;
	private Integer locationId;
	private Integer managerId;
	
	public DepartmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlElement
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@XmlElement
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@XmlElement
	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	@XmlElement
	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", deptName=" + deptName + ", locationId=" + locationId
				+ ", managerId=" + managerId + "]";
	}
	
}
