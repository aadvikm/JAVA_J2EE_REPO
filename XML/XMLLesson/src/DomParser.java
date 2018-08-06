import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//https://sanaulla.info/2013/05/23/parsing-xml-using-dom-sax-and-stax-parser-in-java/
public class DomParser {

	public static void main(String[] args) {
		try{
			//Get the DOM Builder Factory
		    DocumentBuilderFactory factory = 
		        DocumentBuilderFactory.newInstance();
		    //Get the DOM Builder
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    InputStream in = ClassLoader.getSystemResourceAsStream("employee.xml");
		    //Load and Parse the XML document
		    //document contains the complete XML as a Tree.
		    Document document = builder.parse(in);
		    Element employees = document.getDocumentElement();
		    System.out.println(employees.getTagName());
		    List<Employee> employeeArrList = new ArrayList<Employee>();
		    NodeList employeeList = employees.getChildNodes();
		    for(int i = 0; i < employeeList.getLength(); i++){
		    	Node employee = employeeList.item(i);
		    	if(employee.getNodeType() == Node.ELEMENT_NODE){
		    		Employee emp = new Employee();
		    		NamedNodeMap empAttributes = employee.getAttributes();
		    		for(int j = 0; j< empAttributes.getLength(); j++){
		    			Node attribute = empAttributes.item(j);
		    			System.out.println(attribute.getNodeName() +" :  "+attribute.getNodeValue());
		    			if(attribute.getNodeName().equals("empid")){
		    				if(attribute.getNodeValue() != null)//to avoid null pointer exception if value is null
		    					emp.setId(Integer.parseInt(attribute.getNodeValue()));
		    			}
		    			else if(attribute.getNodeName().equals("sex")){
		    				if(attribute.getNodeValue() != null)//to avoid null pointer exception if value is null
		    					emp.setSex(attribute.getNodeValue().charAt(0));
		    			}
		    		}
		    		NodeList employeeChildren = employee.getChildNodes();
		    		for(int k = 0; k < employeeChildren.getLength(); k++){
		    			Node empChildNode =  employeeChildren.item(k);
		    			if(empChildNode.getNodeType() == Node.ELEMENT_NODE){
		    				System.out.println(empChildNode.getNodeName() +" : "+empChildNode.getTextContent());
		    				if(empChildNode.getNodeName().equals("name")){
			    					emp.setName(empChildNode.getTextContent());
			    			}
			    			else if(empChildNode.getNodeName().equals("age")){
		    						emp.setAge(empChildNode.getTextContent());
			    			}
			    			else if(empChildNode.getNodeName().equals("salary")){
		    					emp.setSalary(empChildNode.getTextContent());
			    			}
			    			else if(empChildNode.getNodeName().equals("manager")){
		    					emp.setManager(empChildNode.getTextContent());
			    			}
		    			}
		    		}
		    		employeeArrList.add(emp);
		    	}
		    }
		    System.out.println("Emp Size : "+employeeArrList.size());
		    for(Employee emp : employeeArrList){
		    	System.out.println(emp);
		    }
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}

}
