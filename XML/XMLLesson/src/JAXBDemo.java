import java.io.File;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * JAXB, stands for Java Architecture for XML Binding, using JAXB annotation to convert Java object to / from XML file. 
 * 
 * Marshalling – Convert a Java object into a XML file.
 * Unmarshalling – Convert XML content into a Java Object.
 * 
 *
 */
public class JAXBDemo {

	public static void main(String[] args) throws Exception{
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
		
		//Unmarshalling – Convert XML content into a Java Object.
		InputStream in = ClassLoader.getSystemResourceAsStream("student.xml");
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Student student = (Student) unmarshaller.unmarshal(in);
		System.out.println(student);
		
		//Marshalling – Convert a Java object into a XML file.
		File newFile = new File("C:\\Users\\Brindha\\workspace\\XMLLesson\\src\\studentcopy.xml");
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(student, System.out);
		marshaller.marshal(student, newFile);
		
		
		
	}
}
