import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXParsor {
    public static void main(String[] args) {
        try {

            File inputFile = new File("/home/chunky/events/XmlJSON/src/main/java/employeeSax.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            MyUserHandler userhandler = new MyUserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyUserHandler extends DefaultHandler {

    boolean id = false;
    boolean name = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Employee")) {
            String id = attributes.getValue("num");
            System.out.println("id : " + id);
        } else if (qName.equalsIgnoreCase("deptid")) {
            id = true;
        } else if (qName.equalsIgnoreCase("name")) {
            name = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Employee")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (id) {
            System.out.println("deptid: " + new String(ch, start, length));
            id = false;
        } else if (name) {
            System.out.println(" Name: " + new String(ch, start, length));
            name = false;
        }
    }
}
