package xml.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class LeafNodeIdentifier {

    public static void printLeafNodes(String xmlFilePath) {
        try {
            final Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFilePath);
            final XPathExpression path = XPathFactory.newInstance().newXPath().compile("//*[count(./*) = 0]");
            final NodeList nodeList = (NodeList) path.evaluate(xml, XPathConstants.NODESET);
            for(int i = 0; i < nodeList.getLength(); i++) {
                final Element component = (Element) nodeList.item(i);
                System.out.println(component.getNodeName());
                System.out.println(component.getAttribute("bounds"));
                System.out.println(component.getAttribute("class"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
