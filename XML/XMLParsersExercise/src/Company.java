import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Company {
	private String name;
	private String city;
	private Manager mgr;
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@XmlElement(name ="companyName")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name ="companyCity")
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@XmlElement(name ="manager")
	public Manager getMgr() {
		return mgr;
	}
	
	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", city=" + city + ", mgr=" + mgr + "]";
	}
	
	

}
