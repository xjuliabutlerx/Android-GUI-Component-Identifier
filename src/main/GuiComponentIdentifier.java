package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class GuiComponentIdentifier {

    public static void main (String[] args) throws IOException {

        // Create a new directory (called "output") for the output to go
        String outputDir = "./output/";

        File newDir = new File(outputDir);

        if (newDir.mkdir()) {
            System.out.println("Directory created!");
        } else {
            System.out.println("Error Creating Directory!");
        }

        // Copy the PNG files into the new "output" directory
        File dataFolder = new File ("./data");
        File[] imageList = dataFolder.listFiles();
        InputStream is = null;
        OutputStream os = null;

        for (int i = 0; i < imageList.length; i++) {
            if (imageList[i].getName().endsWith(".png")) {
                try {
                    File newFile = new File ("./output/" + imageList[i].getName());

                    is = new FileInputStream(imageList[i]);
                    os = new FileOutputStream(newFile);

                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }
                } finally {
                    is.close();
                    os.close();
                }
            }
        }

    }

    private void printFileNames() {
        File folder = new File("./data");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File: " + listOfFiles[i].getName());
            }
        }
    }
}
