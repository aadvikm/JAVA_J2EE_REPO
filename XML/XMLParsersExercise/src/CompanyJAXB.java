import java.io.File;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class CompanyJAXB {

	public static void main(String[] args) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);

			InputStream in = ClassLoader.getSystemResourceAsStream("company.xml");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Company com = (Company) unmarshaller.unmarshal(in);
			System.out.println(com);

			File f = new File("C:\\Users\\Brindha\\MyNewWorkSpace\\XMLParsersExercise\\src\\companycopy.xml");
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(com, System.out);
			marshaller.marshal(com, f);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
