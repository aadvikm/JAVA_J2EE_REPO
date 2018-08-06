import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler{
	
	ArrayList<Invoice> invoicArrList =new ArrayList<Invoice>();
	Invoice inv;
	String currTag =null;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("startTag : "+qName);
		currTag =qName;
		if(qName.equals("bill")){
			inv =new Invoice();
			inv.setBillNo(attributes.getValue("no") !=null ?Integer.parseInt(attributes.getValue("no")) : 0);
		}
	}

	 @Override
	  public void characters(char[] ch, int start, int length) 
	          throws SAXException {
			if(currTag != null && currTag.equals("amount")){
				if(inv != null)
					inv.setAmount(Integer.parseInt(String.copyValueOf(ch, start, length)));
			}
			else if(currTag != null && currTag.equals("billdate")){
				if(inv != null)
					inv.setBillDate(String.copyValueOf(ch, start, length));
			}
	  }

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("endTag : "+qName);
		if(qName.equals("bill")){
			invoicArrList.add(inv);
		}
	}

}
