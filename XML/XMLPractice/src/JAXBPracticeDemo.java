import java.io.File;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBPracticeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Invoice.class);
			
			InputStream in = ClassLoader.getSystemResourceAsStream("Invoice.xml");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Invoice inv = (Invoice) unmarshaller.unmarshal(in);
			System.out.println(inv);
			
			File f = new File("C:\\Users\\Brindha\\workspace\\XMLPractice\\src\\invoiecopy.xml");
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(inv, System.out);
			marshaller.marshal(inv, f);
		}	
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
