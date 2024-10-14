package utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The XmlReader class is responsible for reading data from an XML file and converting
 * it into a list of Person objects. It parses the XML file using the DocumentBuilderFactory
 * and DocumentBuilder classes and normalizes the document.
 */
public class XmlReader {

    /**
     * Reads an XML file and extracts Person data from it.
     *
     * This method accepts a file path to an XML file, processes each "person" element
     * in the XML, and extracts relevant details: first name, last name, address,
     * postcode, city, phone number, and email. These details are used to create new
     * Person objects, which are then added to a list.
     *
     * If an exception occurs during the XML parsing process, it is caught, and the
     * stack trace is printed.
     *
     * @param filePath the path to the XML file to be read.
     * @return a list of Person objects extracted from the XML file.
     */
    public List<Person> readXmlPerson(String filePath) {
        List<Person> people = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("person");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
                    String address = element.getElementsByTagName("address").item(0).getTextContent();
                    String postcode = element.getElementsByTagName("postcode").item(0).getTextContent();
                    String city = element.getElementsByTagName("city").item(0).getTextContent();
                    String phone = element.getElementsByTagName("phone").item(0).getTextContent();
                    String email = element.getElementsByTagName("email").item(0).getTextContent();

                    people.add(new Person(firstName, lastName, address, postcode, city, phone, email));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return people;
    }
}
