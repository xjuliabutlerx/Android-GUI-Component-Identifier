package xml.parser;

import coordinates.RectCoordinates;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;

/**
 * This class identifies the leaf-level components from a given XML file and extracts the coordinates
 * from those components and puts them into integer coordinates using the RectCoordinates class.
 */
public class LeafNodeIdentifier {

    public static ArrayList<RectCoordinates> getBoundsOfLeafNodes(String xmlFilePath) throws Exception {
        // Create a list of leaf-level component nodes
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFilePath);
        XPathExpression path = XPathFactory.newInstance().newXPath().compile("//*[count(./*) = 0]");
        NodeList nodeList = (NodeList) path.evaluate(xml, XPathConstants.NODESET);

        // Initialize an empty array list of rectangle coordinates
        ArrayList<RectCoordinates> listOfRects = new ArrayList<>();

        // For each leaf-level component, read in the "bounds" attribute and convert it to rectangle
        // coordinates. Then, store those coordinates in the array list
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element component = (Element) nodeList.item(i);

            String bounds  = component.getAttribute("bounds");
            RectCoordinates newRect = getBoundsFromString(bounds);

            listOfRects.add(newRect);
        }

        return listOfRects;
    }

    private static RectCoordinates getBoundsFromString(String bounds) {
        // Initialize an empty rectangle coordinates object
        RectCoordinates newRect = new RectCoordinates();

        // Initialize an empty string to hold the coordinates as they are read in
        String temp = "";

        for (int i = 0; i < bounds.length(); i++) {

            // If the character is a digit, add it to the temporary string
            if (Character.isDigit(bounds.charAt(i))) {
                temp += bounds.charAt(i);

            } else if (bounds.charAt(i) == ',' || bounds.charAt(i) == ']') {
                // If the character is a comma or close bracket, convert the string of digits
                // into an integer and save it in the rectangle coordinate object

                // Integers will be saved in the following order: x1, y1, x2, and finally y2

                if (newRect.x1BeenSet() == false) {
                    newRect.setX1(Integer.valueOf(temp));

                } else if (newRect.y1BeenSet() == false) {
                    newRect.setY1(Integer.valueOf(temp));

                } else if (newRect.x2BeenSet() == false) {
                    newRect.setX2(Integer.valueOf(temp));

                } else {
                    newRect.setY2(Integer.valueOf(temp));

                }

                // Reset the temporary variable
                temp = "";
            }
        }

        return newRect;
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

}
