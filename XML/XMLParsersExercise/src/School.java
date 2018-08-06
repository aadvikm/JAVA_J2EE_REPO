import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class School {
	private int schoolId;
	private String name;
	private String address;
	private String pinCode;
	private String noOfStudent;
	
	
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute(name ="schoolId")
	public int getSchoolId() {
		return schoolId;
	}


	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	@XmlElement
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement(name ="pin")
	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@XmlElement(name ="noofstudent")
	public String getNoOfStudent() {
		return noOfStudent;
	}


	public void setNoOfStudent(String noOfStudent) {
		this.noOfStudent = noOfStudent;
	}


	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", name=" + name + ", address=" + address + ", pinCode=" + pinCode
				+ ", noOfStudent=" + noOfStudent + "]";
	}

	
	



	

}
