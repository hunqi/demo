package v2ch03.transform;

import org.xml.sax.*;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 * This program demonstrates XSL demonstrations. It applies a transformation to a set of employee
 * records. The records are stored in file employee.dat and turned into xml format. Specify
 * the stylesheet on the command line, e.g,
 * java transform.TransformTest transform/makeprop.xsl
 */
public class TransformTest {
    public static void main(String[] args) throws Exception {
        String baseDir = System.getProperty("user.dir") + "/src/v2ch03";
        Path path;
        if (args.length > 0) path = Paths.get(baseDir, args[0]);
        else path = Paths.get(baseDir, "transform", "makehtml.xsl");
        try (InputStream styleIn = Files.newInputStream(path)) {
            StreamSource styleSource = new StreamSource(styleIn);

            Transformer t = TransformerFactory.newInstance().newTransformer(styleSource);
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty(OutputKeys.METHOD, "xml");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            try (InputStream docIn = Files.newInputStream(Paths.get(baseDir, "transform", "employee.dat"))) {
                t.transform(new SAXSource(new EmployeeReader(), new InputSource(docIn)), new StreamResult(System.out));
            }
        }
    }
}

/**
 * This class reads the flat file employee.dat and reports SAX parser event to act as if
 * it was parsing an xml file
 */
class EmployeeReader implements XMLReader {

    private ContentHandler handler;

    @Override
    public void parse(InputSource input) throws IOException, SAXException {
        InputStream stream = input.getByteStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(stream));
        String rootElement = "staff";
        AttributesImpl atts = new AttributesImpl();

        if (handler == null) throw new SAXException("No content handler");

        handler.startDocument();
        handler.startElement("", rootElement, rootElement, atts);
        String line;

        while ((line = in.readLine()) != null) {
            handler.startElement("", "employee", "employee", atts);
            StringTokenizer t = new StringTokenizer(line, "|");

            handler.startElement("", "name", "name", atts);
            String s = t.nextToken();
            handler.characters(s.toCharArray(), 0, s.length());
            handler.endElement("", "name", "name");

            handler.startElement("", "salary", "salary", atts);
            s = t.nextToken();
            handler.characters(s.toCharArray(), 0, s.length());
            handler.endElement("", "salary", "salary");

            atts.addAttribute("", "year", "year", "CDATA", t.nextToken());
            atts.addAttribute("", "month", "month", "CDATA", t.nextToken());
            atts.addAttribute("", "day", "day", "CDATA", t.nextToken());
            handler.startElement("", "hiredate", "hiredate", atts);
            handler.endElement("", "hiredate", "hiredate");
            atts.clear();

            handler.endElement("", "employee", "employee");
        }

        handler.endElement("", rootElement, rootElement);
        handler.endDocument();
    }

    @Override
    public void setContentHandler(ContentHandler newValue) {
        handler = newValue;
    }

    @Override
    public ContentHandler getContentHandler() {
        return handler;
    }

    @Override
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        return false;
    }

    @Override
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {

    }

    @Override
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        return null;
    }

    @Override
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {

    }

    @Override
    public void setEntityResolver(EntityResolver resolver) {

    }

    @Override
    public EntityResolver getEntityResolver() {
        return null;
    }

    @Override
    public void setDTDHandler(DTDHandler handler) {

    }

    @Override
    public DTDHandler getDTDHandler() {
        return null;
    }

    @Override
    public void setErrorHandler(ErrorHandler handler) {

    }

    @Override
    public ErrorHandler getErrorHandler() {
        return null;
    }


    @Override
    public void parse(String systemId) throws IOException, SAXException {

    }
}