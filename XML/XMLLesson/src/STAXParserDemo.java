import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class STAXParserDemo {
	public static void main(String[] args) throws Exception{
		XMLInputFactory factory = XMLInputFactory.newInstance();
		InputStream in = ClassLoader.getSystemResourceAsStream("employee.xml");
		XMLStreamReader reader = factory.createXMLStreamReader(in);
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Employee emp = null;
		String currTag = null;
		while(reader.hasNext()){
			int event = reader.next();
			switch(event){
			case XMLStreamConstants.START_ELEMENT:
				currTag = reader.getLocalName();
				if(reader.getLocalName().equals("employee")){
					emp = new Employee();
					for(int i=0; i< reader.getAttributeCount(); i++){
						if(reader.getAttributeLocalName(i).equals("empid")){
							emp.setId(reader.getAttributeValue(i) != null ? Integer.parseInt(reader.getAttributeValue(i)) : 0);
						}
					}
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				System.out.println("currTag "+currTag+"  "+reader.getText());
				if(currTag != null && currTag.equals("name")){
					if(emp != null && reader.getText() != null && reader.getText().trim().length() >0)
						emp.setName(reader.getText());
				}
				else if(currTag != null && currTag.equals("age")){
					if(emp != null && reader.getText() != null && reader.getText().trim().length() >0)
						emp.setAge(reader.getText());
				}
				else if(currTag != null && currTag.equals("salary")){
					if(emp != null && reader.getText() != null && reader.getText().trim().length() >0)
						emp.setSalary(reader.getText());
				}
				else if(currTag != null && currTag.equals("manager")){
					if(emp != null && reader.getText() != null && reader.getText().trim().length() >0)
						emp.setManager(reader.getText());
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				if(reader.getLocalName().equals("employee")){
					empList.add(emp);
				}
				break;
			}
		}
		System.out.println("Emp Size : "+empList.size());
		for(Employee employee : empList){
			System.out.println(employee);
		}
		
	}
}
