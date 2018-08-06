import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserDemo {

	public static void main(String[] args) throws Exception{
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		InputStream in = ClassLoader.getSystemResourceAsStream("employee.xml");
		SAXHandler myHandler = new SAXHandler();
		saxParser.parse(in,myHandler);
		 System.out.println("Emp Size : "+ myHandler.employeeList.size());
		for(Employee employee : myHandler.employeeList){
			System.out.println(employee);
		}
	}
}
