import java.io.File;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SchoolJAXB {

	public static void main(String[] args) {
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(School.class);
			
			InputStream in = ClassLoader.getSystemResourceAsStream("school.xml");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			School sch = (School) unmarshaller.unmarshal(in);
			System.out.println(sch);
			
			File f = new File("C:\\Users\\Brindha\\MyNewWorkSpace\\XMLParsersExercise\\src\\schoolcopy.xml");
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(sch, System.out);
			marshaller.marshal(sch, f);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
