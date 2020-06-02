package com.shariqparwez.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class ReadingBytes {
    public static void main(String[] args) {
        // ## 1 - Reading back ints with a DataInputStream [S]
        //readingBytesOperationOne();

        // ## 2 - Reading back ints with a DataInputStream
        //readingBytesOperationTwo();

        // ## 3 - Reading back ints from a GZip compressed file [S]
        readingBytesOperationThree();
    }

    private static void readingBytesOperationOne() {
        // Provide filename along with path in string format
        String fileName = "files/ints.bin";

        try {
            // Get path reference using the fileName
            Path path = Paths.get(fileName);

            // Get size of the file
            long size = Files.size(path);

            // Print size of the file
            System.out.println(path + " size: " + size);
        } catch (IOException e) {
        }
    }

    private static void readingBytesOperationTwo() {
        // Provide filename along with path in string format
        String fileName = "files/ints.bin";

        try {
            // Get path reference using the fileName
            Path path = Paths.get(fileName);

            // Get size of the file
            long size = Files.size(path);

            // Print size of the file
            System.out.println(path + " size: " + size);
        } catch (IOException e) {
        }

        // Create InputStream from file
        // Wrap dataInputStream over inputStream
        try (InputStream inputStream = new FileInputStream(new File(fileName));
             DataInputStream dataInputStream = new DataInputStream(inputStream);) {
            // Array list of type integer
            List<Integer> ints = new ArrayList<>();

            try {
                while (true) {
                    // Add integers as read from file into array list
                    ints.add(dataInputStream.readInt());
                }
            } catch (EOFException e) {
            }

            // Print size of list of ints read from binary file
            System.out.println("ints: " + ints.size());

        } catch (IOException e) {
        }
    }

    private static void readingBytesOperationThree() {
        // Provide filename for compressed file along with path in string format
        String fileName = "files/ints.bin.gz";

        try {
            // Get path reference using the fileName
            Path path = Paths.get(fileName);

            // Get size of the file
            long size = Files.size(path);

            // Print size of the file
            System.out.println(path + " size: " + size);
        } catch (IOException e) {
        }

        // Create InputStream from file
        // Wrap gzipInputStream over inputStream
        // Wrap dataInputStream over gzipInputStream
        try (InputStream inputStream = new FileInputStream(new File(fileName));
             GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
             DataInputStream dataInputStream = new DataInputStream(gzipInputStream);) {
            // Array list of type integer
            List<Integer> ints = new ArrayList<>();

            try {
                while (true) {
                    // Add integers as read from file into array list
                    ints.add(dataInputStream.readInt());
                }
            } catch (EOFException e) {
            }

            // Print size of list of ints read from binary file
            System.out.println("ints: " + ints.size());

        } catch (IOException e) {
        }
    }
}
