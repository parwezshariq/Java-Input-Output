package com.shariqparwez.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReaderInAction {
    public static void main(String[] args) throws IOException {
        // ## 1 - File Creation and File Operations [S]
        //readingCharactersOperationOne();

        // ## 2 - If file do not exist, create a new file
        //readingCharactersOperationTwo();

        // ## 3 - Reading a file line by line using a bufferedReader [S]
        //readingCharactersOperationThree();

        // ## 4 - Improving the pattern using the Java 8 stream API [S]
        //readingCharactersOperationFour();

        // ## 5 - Improving the pattern using the Java 8 stream API
        //readingCharactersOperationFive();

        // ## 5 - Improving the pattern using the Java 8 stream API
        readingCharactersOperationSix();
    }

    private static void readingCharactersOperationOne() {
        // Create instance of file object
        File file = new File("files/bat-weasels.txt");

        // Print filename and also print if file exists
        System.out.println(file.getName());
        System.out.println(file.exists());

        // Create instance of file object
        File nope = new File("files/nope.txt");

        // Print filename and also print if file exists
        // Nope.txt does not exist, in this case
        System.out.println(nope.getName());
        System.out.println(nope.exists());
    }

    private static void readingCharactersOperationTwo() throws IOException {
        // Create instance of file object
        File file = new File("files/bat-weasels.txt");

        // Print filename and also print if file exists
        System.out.println(file.getName());
        System.out.println(file.exists());

        // Create instance of file object
        File nope = new File("files/nope.txt");

        // Print filename and also print if file exists
        // Nope.txt does not exist, in this case
        System.out.println(nope.getName());
        System.out.println(nope.exists());

        // Create non-existing file
        nope.createNewFile();
    }

    private static void readingCharactersOperationThree() {
        // Create instance of file object
        File file = new File("files/bat-weasels.txt");

        // Use try with resources for java to automatically close the reader
        try (Reader reader = new FileReader(file)) {
            // Build bufferedReader on top of FileReader
            BufferedReader bufferedReader = new BufferedReader(reader);

            // Read line from file
            String line = bufferedReader.readLine();

            // If line is not null, print all the lines  and extract
            while (line != null) {
                // Print on console
                System.out.println(line);

                // Read the line using bufferedReader
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readingCharactersOperationFour() {
        // Create instance of path object
        Path path = Paths.get("files/bat-weasels.txt");

        // Use try with resources for java to automatically close the reader
        // Create bufferedReader object using factory class Files through method newBufferedReader
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            // Read line from file
            String line = bufferedReader.readLine();

            // If line is not null, print all the lines  and extract
            while (line != null) {
                // Print on console
                System.out.println(line);

                // Read the line using bufferedReader
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readingCharactersOperationFive() {
        // Create instance of path object
        Path path = Paths.get("files/bat-weasels.txt");

        // Use try with resources for java to automatically close the reader
        // Create bufferedReader object using factory class Files through method newBufferedReader
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            // Read line from file through Java 8 streams
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readingCharactersOperationSix() {
        // Create instance of path object
        Path path = Paths.get("files/bat-weasels.txt");

        // Use try with resources for java to automatically close the reader
        // Create Stream of string, using factory class Files through method newBufferedReader, and fetch lines using lines method
        try (Stream<String> lines = Files.newBufferedReader(path).lines()) {
            // Read line from file through Java 8 streams
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
