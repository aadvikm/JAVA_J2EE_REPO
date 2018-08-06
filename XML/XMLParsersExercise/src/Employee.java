import javax.xml.bind.annotation.XmlElement;

public class Employee {
	private String name;
	private String sal;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name ="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name ="sal")
	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employees [name=" + name + ", sal=" + sal + "]";
	}
}
