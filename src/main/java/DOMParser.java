
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DOMParser {
    public static void main(String[] args) {
        try {
            File inputFile = new File("/home/chunky/events/XmlJSON/src/main/java/employee.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Employee");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Employee id : " + eElement.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    NodeList nodeList = eElement.getElementsByTagName("address");
                    for (int temp1 = 0; temp1 < nodeList.getLength(); temp1++) {
                        Node node = nodeList.item(temp1);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;
                            System.out.println("Street : " + element.getElementsByTagName("street").item(0).getTextContent());
                            System.out.println("city : " + element.getElementsByTagName("city").item(0).getTextContent());

                        }
                    }
                    NodeList nodeList1 = eElement.getElementsByTagName("department");
                    for (int temp1 = 0; temp1 < nodeList1.getLength(); temp1++) {
                        Node node1 = nodeList1.item(temp1);
                        if (node1.getNodeType() == Node.ELEMENT_NODE) {
                            Element element1 = (Element) node1;
                            System.out.println("ID : " + element1.getElementsByTagName("deptid").item(0).getTextContent());
                            System.out.println("NAME : " + element1.getElementsByTagName("deptName").item(0).getTextContent());

                        }
                    }


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
