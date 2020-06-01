package com.shariqparwez.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class WritingCharacters {
    public static void main(String[] args) {
        // ## 1 - Simple writing to a text file [S]
        //writingCharactersOperationOne();

        // ## 2 - Simple writing to a text file
        //writingCharactersOperationTwo();

        // ## 3 - Using the PrintWriter object to print with a format [S]
        //writingCharactersOperationThree();

        // ## 4 - Formatting dates using the print with format pattern [S]
        //writingCharactersOperationFour();

        // ## 5 - Formatting dates using the print with format pattern
        //writingCharactersOperationFive();

        // ## 6 - Formatting dates using the print with format pattern
        writingCharactersOperationSix();
    }

    private static void writingCharactersOperationOne() {
        // Get instance of Path object, onto which writing need to be done
        Path path = Paths.get("files/some-text.txt");

        // Build bufferedWriter using try-with-resources, with standardOpenOption of CREATE and WRITE
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);) {
            // Build PrintWriter object on top of bufferedWriter
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // Print the String onto file
            printWriter.println("Hello World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writingCharactersOperationTwo() {
        // Get instance of Path object, onto which writing need to be done
        Path path = Paths.get("files/some-text.txt");

        // Build bufferedWriter using try-with-resources, with standardOpenOption of CREATE and WRITE
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);) {
            // Build PrintWriter object on top of bufferedWriter
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // Print the String onto file
            printWriter.println("Hello World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writingCharactersOperationThree() {
        // Get instance of Path object, onto which writing need to be done
        Path path = Paths.get("files/some-text.txt");

        // Build bufferedWriter using try-with-resources, with standardOpenOption of CREATE and WRITE
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);) {
            // Build PrintWriter object on top of bufferedWriter
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // Print the String onto file using formatting method i.e. printf
            printWriter.printf("%d %o 0x%04x\n", 12, 8, 248);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writingCharactersOperationFour() {
        // Get instance of Path object, onto which writing need to be done
        Path path = Paths.get("files/some-text.txt");

        // Build bufferedWriter using try-with-resources, with standardOpenOption of CREATE and WRITE
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);) {
            // Build PrintWriter object on top of bufferedWriter
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // Build Calendar instance using gregorian calendar
            // Set date to 1969-July-20
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.set(1969, 6, 20);

            // Print date as specified in format method printf
            printWriter.printf("Man walked on the moon on: %1$tm %1$te %1$tY", calendar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writingCharactersOperationFive() {
        // Get instance of Path object, onto which writing need to be done
        Path path = Paths.get("files/some-text.txt");

        // Build bufferedWriter using try-with-resources, with standardOpenOption of CREATE and WRITE
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);) {
            // Build PrintWriter object on top of bufferedWriter
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // Build Calendar instance using gregorian calendar
            // Set date to 1969-July-20
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.set(1969, 6, 20);

            // Print date as specified in format method printf
            printWriter.printf("Man walked on the moon on: %1$tB %1$tA %1$tY", calendar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writingCharactersOperationSix() {
        // Get instance of Path object, onto which writing need to be done
        Path path = Paths.get("files/some-text.txt");

        // Build bufferedWriter using try-with-resources, with standardOpenOption of CREATE and WRITE
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);) {
            // Build PrintWriter object on top of bufferedWriter
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // Build Calendar instance using gregorian calendar
            // Set date to 1969-July-20
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.set(1969, 6, 20);

            // Print date as specified in format method printf, using locale
            printWriter.printf(Locale.US, "Man walked on the moon on: %1$tB %1$tA %1$tY", calendar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
