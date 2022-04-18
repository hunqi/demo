package org.rs.exercise.xml;

import org.rs.exercise.pojo.DataModelVO;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.Date;

public class PdmParser {

    public static DataModelVO parse(File file) {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        DataModelVO dataModelVO = new DataModelVO();

        try {
            Document doc = doc(file);
            setModel(dataModelVO, xPath, doc);

            System.out.println("result: " + dataModelVO);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return dataModelVO;
    }

    private static void setModel(DataModelVO dataModelVO, XPath xPath, Document doc) throws XPathExpressionException {
        String name = xPath.evaluate(modelExpression("Name"), doc);
        String code = xPath.evaluate(modelExpression("Code"), doc);
        String creator = xPath.evaluate(modelExpression("Creator"), doc);
        Number number = (Number) xPath.evaluate(modelExpression("CreationDate"), doc, XPathConstants.NUMBER);

        dataModelVO.setName(name);
        dataModelVO.setCode(code);
        dataModelVO.setCreator(creator);
        dataModelVO.setCreateTime(new Date(number.longValue() * 1000));
    }

    private static String modelExpression(String node) {
        return "/Model/RootObject/Children/Model/" + node;
    }

    private static Document doc(File file) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            return documentBuilder.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
