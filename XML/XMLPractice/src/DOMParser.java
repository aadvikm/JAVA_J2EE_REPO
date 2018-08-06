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

//DOM Parser Practice..
public class DOMParser {

	public static void main(String[] args) {
		try{
		    DocumentBuilderFactory factory = 
		        DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    InputStream in = ClassLoader.getSystemResourceAsStream("invoice.xml");
		    Document document = builder.parse(in);
		    Element invoice = document.getDocumentElement();
		    System.out.println("root : "+invoice.getTagName());
		    List<Invoice> invoiceArrList = new ArrayList<Invoice>();
		    NodeList invoiceChild = invoice.getChildNodes();
			for (int i = 0; i < invoiceChild.getLength(); i++) {
				Node bill = invoiceChild.item(i);
				if (bill.getNodeType() == Node.ELEMENT_NODE) {
					Invoice inv = new Invoice();
					NamedNodeMap invoiceAtt = bill.getAttributes();
					for (int j = 0; j < invoiceAtt.getLength(); j++) {
						Node billAtt = invoiceAtt.item(j);
						System.out.println(billAtt.getNodeName() + " : " + billAtt.getNodeValue());
						if (billAtt.getNodeName().equals("no")) {
							if (billAtt.getNodeValue() != null)
								inv.setBillNo(Integer.parseInt(billAtt.getNodeValue()));
						}
					}
					NodeList billChild = bill.getChildNodes();
					for (int k = 0; k < billChild.getLength(); k++) {
						Node billChildNodes = billChild.item(k);
						if (billChildNodes.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(billChildNodes.getNodeName() + " : " + billChildNodes.getTextContent());
							if (billChildNodes.getNodeName().equals("amount")) {
								inv.setAmount(Integer.parseInt(billChildNodes.getTextContent()));
							} else if (billChildNodes.getNodeName().equals("billdate")) {
								inv.setBillDate(billChildNodes.getTextContent());
							}
						}
					}
					invoiceArrList.add(inv);
				}
			}
			System.out.println("Invoice Size : "+invoiceArrList.size());
		    for(Invoice inv : invoiceArrList){
		    	System.out.println(inv);
		    }
		  }  	
		catch(Exception exception){
			exception.printStackTrace();
		}

	}

}
