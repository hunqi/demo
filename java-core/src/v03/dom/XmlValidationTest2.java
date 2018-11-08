package v03.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlValidationTest2 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //turn on xml validation
        factory.setValidating(true);
        //set ignoring whitespace as true
        factory.setIgnoringElementContentWhitespace(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Path path = Paths.get(System.getProperty("user.dir"), "src", "v03", "dom", "font02.xml");
        System.out.println("begin read xml file: " + path.toString());
        Document document = builder.parse(path.toFile());

        Element root = document.getDocumentElement();
        System.out.println("root: " + root.getTagName());

        NodeList childNodes = root.getChildNodes();
        System.out.println("childNodes.size: " + childNodes.getLength());

        Element name = (Element) childNodes.item(0);
        Text nameValue = (Text) name.getFirstChild();
        System.out.println("name: " + nameValue.getData());

        Element size = (Element) childNodes.item(1);
        Text sizeValue = (Text) size.getFirstChild();
        System.out.println("size: " + sizeValue.getData());
    }

}
