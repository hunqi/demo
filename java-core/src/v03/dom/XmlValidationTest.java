package v03.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlValidationTest {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Path path = Paths.get(System.getProperty("user.dir"), "src", "v03", "dom", "font01.xml");
        Document document = builder.parse(path.toFile());

        Element root = document.getDocumentElement();
        System.out.println("root: " + root.getTagName());
        NodeList childNodes = root.getChildNodes();
        System.out.println("childNodes.size: " + childNodes.getLength());

        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) instanceof Element) {
                Element elmt = (Element) childNodes.item(i);
                Text elmtValue = (Text) elmt.getFirstChild();
                System.out.println(elmt.getTagName() + ": " + elmtValue.getData());
            }
        }
    }

}
