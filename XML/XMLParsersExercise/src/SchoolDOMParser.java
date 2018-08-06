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

public class SchoolDOMParser {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();
			InputStream in = ClassLoader.getSystemResourceAsStream("school.xml");
			Document document = builder.parse(in);
			Element school = document.getDocumentElement();
			System.out.println(school.getTagName());
			
			School sch =new School();
			NodeList schoolList =school.getChildNodes();
			for(int i =0; i<schoolList.getLength(); i++){
				Node schoolChildNode =schoolList.item(i);
				if(schoolChildNode.getNodeType()==Node.ELEMENT_NODE){
					NamedNodeMap schoolAtt =schoolChildNode.getAttributes();
					for(int j=0; j<schoolAtt.getLength();j++){
						Node attributes =schoolAtt.item(j);
						System.out.println(attributes.getNodeName()+" : "+attributes.getNodeValue());
						if(attributes.getNodeName().equals("schoolId")){
							if(attributes.getNodeValue() !=null)
									sch.setSchoolId(Integer.parseInt(attributes.getNodeValue()));
						}
					}
					System.out.println(schoolChildNode.getNodeName()+ " : "+schoolChildNode.getTextContent());
					if(schoolChildNode.getNodeName().equals("name")){
						sch.setName(schoolChildNode.getTextContent());
					}
					else if(schoolChildNode.getNodeName().equals("address")){
						sch.setAddress(schoolChildNode.getTextContent());
					}
					else if(schoolChildNode.getNodeName().equals("pin")){
						sch.setPinCode(schoolChildNode.getTextContent());
					}
					else if(schoolChildNode.getNodeName().equals("noofstudent")){
						sch.setNoOfStudent(schoolChildNode.getTextContent());
					}
									
				}
			}
			System.out.println("School Object :"+ sch);	
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

}
