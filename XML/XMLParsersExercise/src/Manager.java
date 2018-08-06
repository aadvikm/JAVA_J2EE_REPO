import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class Manager {
	private String name;
	private String sal;
	private String dept;
	private ArrayList<Employee> empList;
	
	public Manager() {
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
	
	@XmlElement(name ="dept")
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@XmlElement(name ="employee")
	public ArrayList<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(ArrayList<Employee> empList) {
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "Manager [name=" + name + ", sal=" + sal + ", dept=" + dept + ", empList=" + empList + "]";
	}
	
}
