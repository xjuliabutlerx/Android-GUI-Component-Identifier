package main;

import java.io.*;

import static xml.parser.LeafNodeIdentifier.printLeafNodes;

public class GuiComponentIdentifier {

    public static void main (String[] args) throws IOException {

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

        // TESTING: Print the file names of everything in the data directory
        printFileNames();
        System.out.println();

        // Find the leaf level components for each xml file
        File dataFolder = new File ("./data");
        File[] imageList = dataFolder.listFiles();

        for (int i = 0; i < imageList.length; i++) {
            if (imageList[i].getName().endsWith(".xml")) {
                System.out.println("FILE: " + imageList[i].getName());
                printLeafNodes("./data/" + imageList[i].getName());
            }
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
