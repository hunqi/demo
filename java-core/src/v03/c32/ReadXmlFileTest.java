package v03.c32;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadXmlFileTest {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Path test1FilePath = Paths.get(System.getProperty("user.dir"), "data", "xml", "test1.xml");
        System.out.println("test1FilePath=" + test1FilePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = test1FilePath.toFile();
        Document doc = builder.parse(file);

        Element root = doc.getDocumentElement();
        System.out.println("root tag: " + root.getTagName());

        NodeList children = root.getChildNodes();
        System.out.println("childNodes.size: " + children.getLength());

        for (int i=0; i<children.getLength(); i++){
            Node node = children.item(i);
            if(node instanceof Element){
                Element  elmt = (Element) node;
                Text textNode = (Text) elmt.getFirstChild();
                String text = textNode.getData();
                System.out.println(elmt.getTagName() + "=" + text);
            }
        }

    }

}
