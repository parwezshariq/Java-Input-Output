package com.shariqparwez.io;

import com.shariqparwez.io.model.Fable;
import com.shariqparwez.io.util.AesopReader;
import com.shariqparwez.io.util.FableData;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class WritingHybridStream {
    public static void main(String[] args) throws IOException {
        //		Aesop's Fables
        //		291
        //		   1235     123 The Wolf and the Lamb
        //		   3271     245 The Bat and the Weasels
        //		<binary texts>

        // ## 1 - Setting up the project for use case study [S]
        //writingHybridStreamOperationOne();

        // ## 2 - Setting up a formatter to write the header | Writing the text header of the aesop's fables file [S]
        //writingHybridStreamOperationTwo();

        // ## 3 - Writing and compressing the text of each fable [S]
        //writingHybridStreamOperationThree();

        // ## 4 - Concatenating the compressed texts [S]
        //writingHybridStreamOperationFour();

        // ## 5 - Creating the correct header with offset and length [S]
        //writingHybridStreamOperationFive();

        // ## 6 - Putting the pieces together in the final file [S]
        writingHybridStreamOperationSix();
    }

    private static void writingHybridStreamOperationOne() {
        // Get reference to object of AesopReader
        AesopReader aesopReader = new AesopReader();

        // Read fables as list of fables from the file
        List<Fable> fables = aesopReader.readFable("files/aesop.txt");

        // Print number of fables read from file
        System.out.println("Number of fable: " + fables.size());
    }

    private static void writingHybridStreamOperationTwo() throws IOException {
        // Get reference to object of AesopReader
        AesopReader aesopReader = new AesopReader();

        // Read fables as list of fables from the file
        List<Fable> fables = aesopReader.readFable("files/aesop.txt");

        // Print number of fables read from file
        System.out.println("Number of fable: " + fables.size());

        // Create byteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Wrap outputStreamWriter over byteArrayOutputStream
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8);

        // Wrap printWriter over outputStreamWriter
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);

        // Print Title and number of fables present in the file
        printWriter.println("Aesop's Fables");
        printWriter.printf("%d\n", fables.size());

        // Print each fable, with its title, i.e., formatted text
        for (Fable fable : fables) {
            printWriter.printf("%7d %7d %s\n", 0, 0, fable.getTitle());
        }

        // Close outputStreamWriter
        outputStreamWriter.close();

        // Generate textOffset
        int textOffset = byteArrayOutputStream.size();

        // Print formatted fables title on console
        System.out.println(new String(byteArrayOutputStream.toByteArray()));
    }

    private static void writingHybridStreamOperationThree() throws IOException {
        // Get reference to object of AesopReader
        AesopReader aesopReader = new AesopReader();

        // Read fables as list of fables from the file
        List<Fable> fables = aesopReader.readFable("files/aesop.txt");

        // Print number of fables read from file
        System.out.println("Number of fable: " + fables.size());

        // Create byteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Wrap outputStreamWriter over byteArrayOutputStream
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8);

        // Wrap printWriter over outputStreamWriter
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);

        // Print Title and number of fables present in the file
        printWriter.println("Aesop's Fables");
        printWriter.printf("%d\n", fables.size());

        // Print each fable, with its title, i.e., formatted text
        for (Fable fable : fables) {
            printWriter.printf("%7d %7d %s\n", 0, 0, fable.getTitle());
        }

        // Close outputStreamWriter
        outputStreamWriter.close();

        // Generate textOffset
        int textOffset = byteArrayOutputStream.size();

        // Print formatted fables title on console
        System.out.println(new String(byteArrayOutputStream.toByteArray()));

        // Create byteArrayOutputStream for writing text of fable
        ByteArrayOutputStream textByteArrayOutputStream = new ByteArrayOutputStream();

        // Iterate over each fable
        for (Fable fable : fables) {
            // Create byteArrayOutputStream for fables
            ByteArrayOutputStream fableByteArrayOutputStream = new ByteArrayOutputStream();

            // Wrap gzipOutputStream for compressing, over byteArrayOutputStream
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fableByteArrayOutputStream);) {
                // Write compressed
                gzipOutputStream.write(fable.getText().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Use compressed bytes with byteArrayOutputStream for writing text
            textByteArrayOutputStream.write(fableByteArrayOutputStream.toByteArray());
        }
    }

    private static void writingHybridStreamOperationFour() throws IOException {
        // Get reference to object of AesopReader
        AesopReader aesopReader = new AesopReader();

        // Read fables as list of fables from the file
        List<Fable> fables = aesopReader.readFable("files/aesop.txt");

        // Print number of fables read from file
        System.out.println("Number of fable: " + fables.size());

        // Create byteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Wrap outputStreamWriter over byteArrayOutputStream
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8);

        // Wrap printWriter over outputStreamWriter
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);

        // Print Title and number of fables present in the file
        printWriter.println("Aesop's Fables");
        printWriter.printf("%d\n", fables.size());

        // Print each fable, with its title, i.e., formatted text
        for (Fable fable : fables) {
            printWriter.printf("%7d %7d %s\n", 0, 0, fable.getTitle());
        }

        // Close outputStreamWriter
        outputStreamWriter.close();

        // Generate textOffset
        int textOffset = byteArrayOutputStream.size();

        // Print formatted fables title on console
        System.out.println(new String(byteArrayOutputStream.toByteArray()));

        // Create byteArrayOutputStream for writing text of fable
        ByteArrayOutputStream textByteArrayOutputStream = new ByteArrayOutputStream();

        // Set offset value by using textOffSet
        int offset = textOffset;

        // Initialize arrayList to hold list of fableData
        List<FableData> fableDataList = new ArrayList<>();

        // Iterate over each fable
        for (Fable fable : fables) {
            // Create byteArrayOutputStream for fables
            ByteArrayOutputStream fableByteArrayOutputStream = new ByteArrayOutputStream();

            // Wrap gzipOutputStream for compressing, over byteArrayOutputStream
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fableByteArrayOutputStream);) {
                // Write compressed
                gzipOutputStream.write(fable.getText().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Get the length of byteArrayOutputStream for each fable
            int length = fableByteArrayOutputStream.size();

            // Use compressed bytes with byteArrayOutputStream for writing text
            textByteArrayOutputStream.write(fableByteArrayOutputStream.toByteArray());

            // Create new fableData using the computed values
            FableData fableData = new FableData(fable, offset, length);

            // Increase the offset with the length of each fable
            offset += length;

            // Add fable into fableData list
            fableDataList.add(fableData);
        }

        // Close byteArrayOutputStream build for reading text of fables
        textByteArrayOutputStream.close();
    }

    private static void writingHybridStreamOperationFive() throws IOException {
        // Get reference to object of AesopReader
        AesopReader aesopReader = new AesopReader();

        // Read fables as list of fables from the file
        List<Fable> fables = aesopReader.readFable("files/aesop.txt");

        // Print number of fables read from file
        System.out.println("Number of fable: " + fables.size());

        // Create byteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Wrap outputStreamWriter over byteArrayOutputStream
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8);

        // Wrap printWriter over outputStreamWriter
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);

        // Print Title and number of fables present in the file
        printWriter.println("Aesop's Fables");
        printWriter.printf("%d\n", fables.size());

        // Print each fable, with its title, i.e., formatted text
        for (Fable fable : fables) {
            printWriter.printf("%7d %7d %s\n", 0, 0, fable.getTitle());
        }

        // Close outputStreamWriter
        outputStreamWriter.close();

        // Generate textOffset
        int textOffset = byteArrayOutputStream.size();

        // Create byteArrayOutputStream for writing text of fable
        ByteArrayOutputStream textByteArrayOutputStream = new ByteArrayOutputStream();

        // Set offset value by using textOffSet
        int offset = textOffset;

        // Initialize arrayList to hold list of fableData
        List<FableData> fableDataList = new ArrayList<>();

        // Iterate over each fable
        for (Fable fable : fables) {
            // Create byteArrayOutputStream for fables
            ByteArrayOutputStream fableByteArrayOutputStream = new ByteArrayOutputStream();

            // Wrap gzipOutputStream for compressing, over byteArrayOutputStream
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fableByteArrayOutputStream);) {
                // Write compressed
                gzipOutputStream.write(fable.getText().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Get the length of byteArrayOutputStream for each fable
            int length = fableByteArrayOutputStream.size();

            // Use compressed bytes with byteArrayOutputStream for writing text
            textByteArrayOutputStream.write(fableByteArrayOutputStream.toByteArray());

            // Create new fableData using the computed values
            FableData fableData = new FableData(fable, offset, length);

            // Increase the offset with the length of each fable
            offset += length;

            // Add fable into fableData list
            fableDataList.add(fableData);
        }

        // Close byteArrayOutputStream build for reading text of fables
        textByteArrayOutputStream.close();

        // Initialize with new reference for byteArrayOutputStream
        byteArrayOutputStream = new ByteArrayOutputStream();

        // Initialize outputStreamWriter over byteArrayOutputStream with new reference
        outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8);

        // Initialize printWriter over outputStreamWriter with new reference
        printWriter = new PrintWriter(outputStreamWriter);

        // Print Title and number of fables present in the file
        printWriter.println("Aesop's Fables");
        printWriter.printf("%d\n", fables.size());

        // Print each fable, with its title, i.e., formatted text
        for (FableData fableData : fableDataList) {
            printWriter.printf("%7d %7d %s\n", fableData.getOffset(), fableData.getLength(), fableData.getFable().getTitle());
        }

        // Flush the content of printWriter
        printWriter.flush();

        // Close outputStreamWriter
        outputStreamWriter.close();

        // Print formatted fables title on console
        System.out.println(new String(byteArrayOutputStream.toByteArray()));
    }

    private static void writingHybridStreamOperationSix() throws IOException {
        // Get reference to object of AesopReader
        AesopReader aesopReader = new AesopReader();

        // Read fables as list of fables from the file
        List<Fable> fables = aesopReader.readFable("files/aesop.txt");

        // Print number of fables read from file
        System.out.println("Number of fable: " + fables.size());

        // Create byteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Wrap outputStreamWriter over byteArrayOutputStream
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8);

        // Wrap printWriter over outputStreamWriter
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);

        // Print Title and number of fables present in the file
        printWriter.println("Aesop's Fables");
        printWriter.printf("%d\n", fables.size());

        // Print each fable, with its title, i.e., formatted text
        for (Fable fable : fables) {
            printWriter.printf("%7d %7d %s\n", 0, 0, fable.getTitle());
        }

        // Close outputStreamWriter
        outputStreamWriter.close();

        // Generate textOffset
        int textOffset = byteArrayOutputStream.size();

        // Create byteArrayOutputStream for writing text of fable
        ByteArrayOutputStream textByteArrayOutputStream = new ByteArrayOutputStream();

        // Set offset value by using textOffSet
        int offset = textOffset;

        // Initialize arrayList to hold list of fableData
        List<FableData> fableDataList = new ArrayList<>();

        // Iterate over each fable
        for (Fable fable : fables) {
            // Create byteArrayOutputStream for fables
            ByteArrayOutputStream fableByteArrayOutputStream = new ByteArrayOutputStream();

            // Wrap gzipOutputStream for compressing, over byteArrayOutputStream
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fableByteArrayOutputStream);) {
                // Write compressed
                gzipOutputStream.write(fable.getText().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Get the length of byteArrayOutputStream for each fable
            int length = fableByteArrayOutputStream.size();

            // Use compressed bytes with byteArrayOutputStream for writing text
            textByteArrayOutputStream.write(fableByteArrayOutputStream.toByteArray());

            // Create new fableData using the computed values
            FableData fableData = new FableData(fable, offset, length);

            // Increase the offset with the length of each fable
            offset += length;

            // Add fable into fableData list
            fableDataList.add(fableData);
        }

        // Close byteArrayOutputStream build for reading text of fables
        textByteArrayOutputStream.close();

        // Initialize with new reference for byteArrayOutputStream
        byteArrayOutputStream = new ByteArrayOutputStream();

        // Initialize outputStreamWriter over byteArrayOutputStream with new reference
        outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8);

        // Initialize printWriter over outputStreamWriter with new reference
        printWriter = new PrintWriter(outputStreamWriter);

        // Print Title and number of fables present in the file
        printWriter.println("Aesop's Fables");
        printWriter.printf("%d\n", fables.size());

        // Print each fable, with its title, i.e., formatted text
        for (FableData fableData : fableDataList) {
            printWriter.printf("%7d %7d %s\n", fableData.getOffset(), fableData.getLength(), fableData.getFable().getTitle());
        }

        // Flush the content of printWriter
        printWriter.flush();

        // Print formatted fables title on console
        System.out.println(new String(byteArrayOutputStream.toByteArray()));

        // Through byteArrayOutputStream write the entire content of textByteArrayOutputStream
        byteArrayOutputStream.write(textByteArrayOutputStream.toByteArray());

        // Close byteArrayOutputStream
        byteArrayOutputStream.close();

        // Set up file reference with the pathname, where file content need to be stored
        File file = new File("files/aesops-compressed.bin");

        // Create outputStream over fileOutputStream
        try (OutputStream outputStream = new FileOutputStream(file)) {
            // Write to file using the content of byteArrayOutputStream
            outputStream.write(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
