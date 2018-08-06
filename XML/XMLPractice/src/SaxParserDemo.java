import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxParserDemo {
	
	public static void main(String[] args){
		try{
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			InputStream in = ClassLoader.getSystemResourceAsStream("invoice.xml");
			SAXHandler saxHandler =new SAXHandler();
			saxParser.parse(in,saxHandler );
			System.out.println("Invoice Size : "+ saxHandler.invoicArrList.size());
			for(Invoice inv : saxHandler.invoicArrList){
				System.out.println(inv);
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}

}
