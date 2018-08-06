import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler{
	
	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	Employee emp;
	String currTag = null;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("startElement "+ qName);
		currTag = qName;
		if(qName.equals("employee")){
			emp = new Employee();
			emp.setId(attributes.getValue("empid") != null ? Integer.parseInt(attributes.getValue("empid")) : 0);
			emp.setSex(attributes.getValue("sex") != null ? attributes.getValue("sex").charAt(0) : ' ');
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(currTag != null && currTag.equals("name")){
			if(emp != null)
				emp.setName(String.copyValueOf(ch, start, length));
		}
		else if(currTag != null && currTag.equals("age")){
			if(emp != null)
				emp.setAge(String.copyValueOf(ch, start, length));
		}
		else if(currTag != null && currTag.equals("salary")){
			if(emp != null)
				emp.setSalary(String.copyValueOf(ch, start, length));
		}
		else if(currTag != null && currTag.equals("manager")){
			if(emp != null)
				emp.setManager(String.copyValueOf(ch, start, length));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("endElement "+ qName);
		if(qName.equals("employee")){
			employeeList.add(emp);
		}
	}

}
