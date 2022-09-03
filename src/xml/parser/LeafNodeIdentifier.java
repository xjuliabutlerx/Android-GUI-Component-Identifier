package xml.parser;

import coordinates.RectCoordinates;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;

public class LeafNodeIdentifier {

    public static ArrayList<RectCoordinates> getBoundsOfLeafNodes(String xmlFilePath) throws Exception {
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFilePath);
        XPathExpression path = XPathFactory.newInstance().newXPath().compile("//*[count(./*) = 0]");
        NodeList nodeList = (NodeList) path.evaluate(xml, XPathConstants.NODESET);

        ArrayList<RectCoordinates> listOfRects = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element component = (Element) nodeList.item(i);

            String bounds  = component.getAttribute("bounds");
            RectCoordinates newRect = getBoundsFromString(bounds);

            listOfRects.add(newRect);
        }

        return listOfRects;
    }

    public static void printLeafNodes(String xmlFilePath) {
        try {
            Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFilePath);
            XPathExpression path = XPathFactory.newInstance().newXPath().compile("//*[count(./*) = 0]");
            NodeList nodeList = (NodeList) path.evaluate(xml, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element component = (Element) nodeList.item(i);
                System.out.println(component.getNodeName());
                System.out.println(component.getAttribute("bounds"));
                System.out.println(component.getAttribute("class"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static RectCoordinates getBoundsFromString(String bounds) {
        RectCoordinates newRect = new RectCoordinates();
        String temp = "";
        for (int i = 0; i < bounds.length(); i++) {
            if (Character.isDigit(bounds.charAt(i))) {
                temp += bounds.charAt(i);
            } else if (bounds.charAt(i) == ',' || bounds.charAt(i) == ']') {
                if (newRect.x1BeenSet() == false) {
                    newRect.setX1(Integer.valueOf(temp));
                } else if (newRect.y1BeenSet() == false) {
                    newRect.setY1(Integer.valueOf(temp));
                } else if (newRect.x2BeenSet() == false) {
                    newRect.setX2(Integer.valueOf(temp));
                } else {
                    newRect.setY2(Integer.valueOf(temp));
                }

                temp = "";
            }
        }

        //newRect.print();

        return newRect;
    }

}
