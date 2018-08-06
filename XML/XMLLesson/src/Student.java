import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private int id;
	private String name;
	private String age;
	private String deptId;
	private Subject subject;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@XmlAttribute(name="stuId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@XmlElement
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	@XmlElement(name="subject")
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", deptId=" + deptId + ", subject=" + subject
				+ "]";
	}
	
	
}
