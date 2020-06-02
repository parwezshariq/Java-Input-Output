package com.shariqparwez.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadingZipFiles {
    public static void main(String[] args) {
        // ## 1 - Reading an archive file with the ZipInputStream [S]
        //readingZipFilesOperationOne();

        // ## 2 - Reading an archive file with the ZipInputStream
        readingZipFilesOperationTwo();
    }

    private static void readingZipFilesOperationOne() {
        // Provide filename for the archived zip file
        String fileName = "files/archive.zip";

        // Create InputStream using FileInputStream through filename of archived file
        // Wrap ZipInputStream over InputStream
        // Wrap DataInputStream over ZipInputStream
        try (InputStream inputStream = new FileInputStream(new File(fileName));
             ZipInputStream zipInputStream = new ZipInputStream(inputStream);
             DataInputStream dataInputStream = new DataInputStream(zipInputStream);) {

            // Fetch entry from the zip
            ZipEntry entry = zipInputStream.getNextEntry();

            // Iterate while zip file is having content or entry in it
            while (entry != null) {
                // Print content or entry information
                System.out.println(entry);

                // Get the reference of next content or entry of zip file
                entry = zipInputStream.getNextEntry();
            }
        } catch (IOException e) {
        }
    }

    private static void readingZipFilesOperationTwo() {
        // Provide filename for the archived zip file
        String fileName = "files/archive.zip";

        // Create InputStream using FileInputStream through filename of archived file
        // Wrap ZipInputStream over InputStream
        // Wrap DataInputStream over ZipInputStream
        try (InputStream inputStream = new FileInputStream(new File(fileName));
             ZipInputStream zipInputStream = new ZipInputStream(inputStream);
             DataInputStream dataInputStream = new DataInputStream(zipInputStream);) {

            // Fetch entry from the zip
            ZipEntry entry = zipInputStream.getNextEntry();

            // Iterate while zip file is having content or entry in it
            while (entry != null) {
                // If entry is of directory type, print directory information
                if (entry.isDirectory()) {
                    System.out.println("Reading directory: " + entry);
                } else {
                    // If file type is binary type, process it accordingly
                    if (entry.getName().endsWith(".bin")) {
                        // Print binary file information
                        System.out.println("Reading file: " +  entry);

                        // List of integers to hold data fetched from binary file
                        List<Integer> ints = new ArrayList<>();
                        try {
                            while (true) {
                                // Read and content of the binary file
                                ints.add(dataInputStream.readInt());
                            }
                        } catch (EOFException e) {
                        }

                        // Print size of the array list having content read from binary file
                        System.out.println("Ints: " + ints.size());

                    } else if (entry.getName().endsWith(".txt")) { // If file type is of text type, process it accordingly
                        // Print out file details
                        System.out.println("Reading file: " +  entry);

                        // Read content of the file
                        String content = dataInputStream.readUTF();

                        // Print content of the file
                        System.out.println("Content: " + content);
                    }
                }

                // Get the reference of next content or entry of zip file
                entry = zipInputStream.getNextEntry();
            }
        } catch (IOException e) {
        }
    }
}
