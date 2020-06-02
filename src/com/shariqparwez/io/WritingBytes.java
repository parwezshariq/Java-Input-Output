package com.shariqparwez.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.zip.GZIPOutputStream;

public class WritingBytes {
    public static void main(String[] args) {
        // ## 1 - Writing primitive types to a file [S]
        //writingBytesOperationOne();

        // ## 2 - Writing primitive types to a file
        //writingBytesOperationTwo();

        // ## 3 - Writing primitive types to a file
        //writingBytesOperationThree();

        // ## 4 - Writing UTF strings to bytes file [S]
        //writingBytesOperationFour();

        // ## 5 - Writing UTF strings to bytes file
        //writingBytesOperationFive();

        // ## 6 - Writing ints to bytes file with a DataOutputStream [S]
        //writingBytesOperationSix();

        // ## 7 - Writing ints to a file compressed with GZip [S]
        writingBytesOperationSeven();
    }

    private static void writingBytesOperationOne() {
        // Create File object, for binary file
        File file = new File("files/ints.bin");

        // Create OutputStream object using file object
        try (OutputStream outputStream = new FileOutputStream(file);) {
            // Wrap OutputStream object into DataOutputStream
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // Use writeInt method to write integer as bytes into binary file
            dataOutputStream.writeInt(10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writingBytesOperationTwo() {
        // Define path name for the binary file
        String pathName = "files/ints.bin";

        // Create File object, for binary file
        File file = new File(pathName);

        // Create OutputStream object using file object
        try (OutputStream outputStream = new FileOutputStream(file);) {
            // Wrap OutputStream object into DataOutputStream
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // Use writeInt method to write integer as bytes into binary file
            dataOutputStream.writeInt(10);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Get the path of the binary file created
            Path path = Paths.get(pathName);

            // Get the size of the file
            long size = Files.size(path);

            // Print out size of the binary file
            System.out.println(path + " size: " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writingBytesOperationThree() {
        // Define path name for the binary file
        String pathName = "files/ints.bin";

        // Create File object, for binary file
        File file = new File(pathName);

        // Create OutputStream object using file object
        try (OutputStream outputStream = new FileOutputStream(file);) {
            // Wrap OutputStream object into DataOutputStream
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // Use writeDouble method to write double as bytes into binary file
            dataOutputStream.writeDouble(10d);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Get the path of the binary file created
            Path path = Paths.get(pathName);

            // Get the size of the file
            long size = Files.size(path);

            // Print out size of the binary file
            System.out.println(path + " size: " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writingBytesOperationFour() {
        // Define path name for the binary file
        String pathName = "files/ints.bin";

        // Create File object, for binary file
        File file = new File(pathName);

        // Create OutputStream object using file object
        try (OutputStream outputStream = new FileOutputStream(file);) {
            // Wrap OutputStream object into DataOutputStream
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // Use writeUTF method to write string as bytes into binary file
            dataOutputStream.writeUTF("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Get the path of the binary file created
            Path path = Paths.get(pathName);

            // Get the size of the file
            long size = Files.size(path);

            // Print out size of the binary file
            System.out.println(path + " size: " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writingBytesOperationFive() {
        // Define path name for the binary file
        String pathName = "files/ints.bin";

        // Create File object, for binary file
        File file = new File(pathName);

        // Create OutputStream object using file object
        try (OutputStream outputStream = new FileOutputStream(file);) {
            // Wrap OutputStream object into DataOutputStream
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // Use writeUTF method to write string as bytes into binary file
            dataOutputStream.writeUTF("Hèllo");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Get the path of the binary file created
            Path path = Paths.get(pathName);

            // Get the size of the file
            long size = Files.size(path);

            // Print out size of the binary file
            System.out.println(path + " size: " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writingBytesOperationSix() {
        // Define path name for the binary file
        String pathName = "files/ints.bin";

        // Create File object, for binary file
        File file = new File(pathName);

        // Create OutputStream object using file object
        try (OutputStream outputStream = new FileOutputStream(file);) {
            // Wrap OutputStream object into DataOutputStream
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // Write integers from 1 to 1000 into binary file
            IntStream.range(0, 1000).forEach(i -> {
                try {
                    dataOutputStream.writeInt(i);
                } catch (IOException e) {}
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Get the path of the binary file created
            Path path = Paths.get(pathName);

            // Get the size of the file
            long size = Files.size(path);

            // Print out size of the binary file
            System.out.println(path + " size: " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writingBytesOperationSeven() {
        // Define path name for the binary file
        String pathName = "files/ints.bin.gz";

        // Create File object, for binary file
        File file = new File(pathName);

        // Create OutputStream object using file object
        // Wrap OutputStream object into GZIPOutputStream
        // Wrap GZIPOutputStream object into DataOutputStream
        try (OutputStream outputStream = new FileOutputStream(file);
             GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
             DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream);) {
            // Write integers from 1 to 1000 into binary file
            IntStream.range(0, 1000).forEach(i -> {
                try {
                    dataOutputStream.writeInt(i);
                } catch (IOException e) {}
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Get the path of the binary file created
            Path path = Paths.get(pathName);

            // Get the size of the file
            long size = Files.size(path);

            // Print out size of the binary file
            System.out.println(path + " size: " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
