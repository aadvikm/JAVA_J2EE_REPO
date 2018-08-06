import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class SchoolSTAXParser {

	public static void main(String[] args) {
		try{
			XMLInputFactory factory = XMLInputFactory.newInstance();
			InputStream in = ClassLoader.getSystemResourceAsStream("school.xml");
			XMLStreamReader reader = factory.createXMLStreamReader(in);
			School sch =null;
			String currTag =null;
			while(reader.hasNext()){
				int eve = reader.next();
				switch(eve){
				case XMLStreamConstants.START_ELEMENT:
					currTag = reader.getLocalName();
					if(reader.getLocalName().equals("school")){
						sch = new School();
					}
					else if(reader.getLocalName().equals("name")){
						for(int i=0; i<reader.getAttributeCount(); i++){
							if(reader.getAttributeLocalName(i).equals("schoolId")){
								sch.setSchoolId(reader.getAttributeValue(i) != null ? Integer.parseInt(reader.getAttributeValue(i)) :0);
							}
						}
						
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					System.out.println("currTag "+currTag+"  "+reader.getText());
					if(currTag != null && currTag.equals("name")){
						if(sch != null && reader.getText().trim().length() >0)
						sch.setName(reader.getText());
					}
					else if(currTag != null && currTag.equals("address")){
						if(sch != null && reader.getText().trim().length() >0)
							sch.setAddress(reader.getText());
					}
					else if(currTag != null && currTag.equals("pin")){
						if(sch != null && reader.getText().trim().length() >0)
							sch.setPinCode(reader.getText());
					}
					else if(currTag != null && currTag.equals("noofstudent")){
						if(sch != null && reader.getText().trim().length() >0)
							sch.setNoOfStudent(reader.getText());
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					break;
				}
				
			}
			System.out.println(sch);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
