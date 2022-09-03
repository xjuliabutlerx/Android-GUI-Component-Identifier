package main;

import coordinates.RectCoordinates;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import static xml.parser.LeafNodeIdentifier.getBoundsOfLeafNodes;

/**
 * This class contains the main method and controls the drawing of the rectangles on new images.
 * It also saves the new images into a new directory called "output."
 */
public class GuiComponentIdentifier {

    public static void main (String[] args) {

        // Create a new directory (called "output") for the output to go
        String outputDir = "./output/";

        File newDir = new File(outputDir);

        if (newDir.mkdir()) {
            System.out.println("Directory created!");
            System.out.println();
        } else {
            System.out.println("Error Creating Directory!");
            System.out.println();
        }

        // Prepare to read in files from the data directory
        File dataFolder = new File ("./data");
        File[] imageList = dataFolder.listFiles();
        InputStream is = null;
        OutputStream os = null;

        // Identify the leaf level components for each XML file and draw rectangles around these
        // components for each respective PNG file
        ArrayList<RectCoordinates> listOfRects = new ArrayList<>();
        for (int i = 0; i < imageList.length; i++) {
            if (imageList[i].getName().endsWith(".xml")) {
                System.out.println("FILE: " + imageList[i].getName());
                try {
                    listOfRects = getBoundsOfLeafNodes("./data/" + imageList[i].getName());
                    System.out.println(listOfRects.toString());

                    String imageName = imageList[i].getName();
                    imageName = imageName.substring(0, imageName.length() - 4);
                    imageName = imageName.concat(".png");
                    System.out.println(imageName);

                    drawRects(imageName, listOfRects);

                    System.out.println();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void drawRects(String imageFileName, ArrayList<RectCoordinates> rects) {
        try {
            // Load the provided image from the "data" directory
            BufferedImage orgImg = ImageIO.read(new File("./data/" + imageFileName));

            // Create a new PNG file for the highlighted components
            File newImg = new File ("./output/" + imageFileName);

            // Prepare a graphics editor, set the stroke to a width of 5, and set the yellow to color
            Graphics2D editor = orgImg.createGraphics();
            Stroke stroke = new BasicStroke(5);
            editor.setStroke(stroke);
            editor.setColor(Color.YELLOW);

            // For each rectangle coordinate in the list, draw the corresponding rectangle
            for (int i = 0; i < rects.size() - 1; i++) {
                editor.drawRect(rects.get(i).getX1(),
                                rects.get(i).getY1(),
                                rects.get(i).calculateWidth(),
                                rects.get(i).calculateHeight());
            }

            // Save the image
            ImageIO.write(orgImg, "png", newImg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printFileNames() {
        File folder = new File("./data");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File: " + listOfFiles[i].getName());
            }
        }
    }
}
