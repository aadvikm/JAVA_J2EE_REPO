import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SchoolSAXParser {

	public static void main(String[] args) {

		try {
			SAXParserFactory saxParserFac = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFac.newSAXParser();
			InputStream in = ClassLoader.getSystemResourceAsStream("school.xml");
			SchoolSAXHandler saxHand =new SchoolSAXHandler();
			saxParser.parse(in, saxHand);
			System.out.println("School Sax :" + saxHand.sch);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
