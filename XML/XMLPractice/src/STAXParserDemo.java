import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class STAXParserDemo {

	public static void main(String[] args){
		try{
			InputStream in = ClassLoader.getSystemResourceAsStream("invoice.xml");
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.createXMLStreamReader(in);
			ArrayList<Invoice> invList = new ArrayList<Invoice>();
			Invoice inv = null;
			String currTag = null;
			while(reader.hasNext()){
				int eve =reader.next();
				switch(eve){
				case XMLStreamConstants.START_ELEMENT:
					currTag =reader.getLocalName();
					if(reader.getLocalName().equals("bill")){
						inv=new Invoice();
						for(int i=0; i< reader.getAttributeCount(); i++){
							if(reader.getAttributeLocalName(i).equals("no")){
								inv.setBillNo(reader.getAttributeValue(i) != null ? Integer.parseInt(reader.getAttributeValue(i)) : 0);
							}
						}
					}
					break;
				case  XMLStreamConstants.CHARACTERS:
					System.out.println("currTag "+currTag+"  "+reader.getText());
					if(currTag != null && currTag.equals("amount")){
						if(inv != null && reader.getText() != null && reader.getText().trim().length() >0)
							inv.setAmount(reader.getText() !=null ?Integer.parseInt(reader.getText()) :0);
					}
					else if(currTag != null && currTag.equals("billdate")){
						if(inv != null && reader.getText() != null && reader.getText().trim().length() >0)
							inv.setBillDate(reader.getText());
					}
					break;
				case  XMLStreamConstants.END_ELEMENT:
					System.out.println(reader.getLocalName());if(reader.getLocalName().equals("bill")){
						invList.add(inv);
					}
					break;
				}
			}
			
			System.out.println("Invoice Size : "+invList.size());
			for(Invoice invo : invList){
				System.out.println(invo);
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		
		
	}
}
