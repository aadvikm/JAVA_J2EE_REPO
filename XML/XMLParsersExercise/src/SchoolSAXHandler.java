import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SchoolSAXHandler extends DefaultHandler{
	
	School sch =null;
	String currTag =null;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement "+ qName);
		currTag = qName;
		if(qName.equals("school")){
			sch =new School();
		}
		else if(qName.equals("name")){
			sch.setSchoolId(attributes.getValue("schoolId") != null ? Integer.parseInt(attributes.getValue("schoolId")) : 0);
		}
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("currTag "+currTag);
		if(currTag != null && currTag.equals("name")){
			if(sch != null && String.copyValueOf(ch, start, length).trim().length()>0)
			sch.setName(String.copyValueOf(ch, start, length));
		}
		else if(currTag != null && currTag.equals("address")){
			if(sch != null && String.copyValueOf(ch, start, length).trim().length()>0)
				sch.setAddress(String.copyValueOf(ch, start, length));
		}
		else if(currTag != null && currTag.equals("pin")){
			if(sch != null && String.copyValueOf(ch, start, length).trim().length()>0)
				sch.setPinCode(String.copyValueOf(ch, start, length));
		}
		else if(currTag != null && currTag.equals("noofstudent")){
			if(sch != null && String.copyValueOf(ch, start, length).trim().length()>0)
				sch.setNoOfStudent(String.copyValueOf(ch, start, length));
		}
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("endElement "+ qName);
	}
}
