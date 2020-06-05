package com.shariqparwez.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;

public class ReadingHybridStream {
    public static void main(String[] args) throws IOException {
        // ## 1 - Reading back a given fable from the list [S]
        //readingHybridStreamOperationOne();

        // ## 2 - Understanding mark, reset and skip [S]
        //readingHybridStreamOperationTwo();

        // ## 3 - Reading and unzipping the fable text [S]
        readingHybridStreamOperationThree();
    }

    private static void readingHybridStreamOperationOne() throws IOException {
        // Set line number of the first fable
        int lineOfTheFirstFable = 1;

        // Set fable number
        int n = 290;

        // Provide fileName to be read for fables content
        String pathName = "files/aesops-compressed.bin";

        // New file reference for fables content
        File file = new File(pathName);

        // Get the size of the fable file
        int size = (int) Files.size(Paths.get(pathName));

        // Create inputStream over fileInputStream
        // Wrap bufferedInputStream over inputStream
        try (InputStream inputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            // Wrap inputStreamReader over bufferedInputStream
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);

            // Wrap lineNumberReader over inputStreamReader
            LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);

            // Read line
            lineNumberReader.readLine();

            // Iterate until correct fable number is retrieved
            while (lineNumberReader.getLineNumber() < n + lineOfTheFirstFable) {
                // Read line
                lineNumberReader.readLine();
            }

            // Get the fable data from lineNumberReader
            String fableData = lineNumberReader.readLine();

            // Print fable data
            System.out.println(fableData);

            // Extract offset, length, title, from read line
            int offset = Integer.parseInt(fableData.substring(0, 7).trim());
            int length = Integer.parseInt(fableData.substring(9, 16).trim());
            String title = fableData.substring(16);

            // Print the extracted information
            System.out.printf("%d %d %s\n", offset, length, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readingHybridStreamOperationTwo() throws IOException {
        // Set line number of the first fable
        int lineOfTheFirstFable = 1;

        // Set fable number
        int n = 290;

        // Provide fileName to be read for fables content
        String pathName = "files/aesops-compressed.bin";

        // New file reference for fables content
        File file = new File(pathName);

        // Get the size of the fable file
        int size = (int) Files.size(Paths.get(pathName));

        // Create inputStream over fileInputStream
        // Wrap bufferedInputStream over inputStream
        try (InputStream inputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {

            // Set maximum limit of bytes to be read
            bufferedInputStream.mark(size + 1);

            // Wrap inputStreamReader over bufferedInputStream
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);

            // Wrap lineNumberReader over inputStreamReader
            LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);

            // Read line
            lineNumberReader.readLine();

            // Iterate until correct fable number is retrieved
            while (lineNumberReader.getLineNumber() < n + lineOfTheFirstFable) {
                // Read line
                lineNumberReader.readLine();
            }

            // Get the fable data from lineNumberReader
            String fableData = lineNumberReader.readLine();

            // Print fable data
            System.out.println(fableData);

            // Extract offset, length, title, from read line
            int offset = Integer.parseInt(fableData.substring(0, 7).trim());
            int length = Integer.parseInt(fableData.substring(9, 16).trim());
            String title = fableData.substring(16);

            // Print the extracted information
            System.out.printf("%d %d %s\n", offset, length, title);

            // Reset bufferedInputStream
            bufferedInputStream.reset();

            // Set skip bytes from offset value
            int skip = (int) bufferedInputStream.skip(offset);

            // Set the skip value in totalSkip
            int totalSkip = skip;

            // Iterate with the skip value until less than offset value
            while (totalSkip < offset) {
                // Update skip and total skip value
                skip = (int) bufferedInputStream.skip(offset - totalSkip);
                totalSkip += skip;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readingHybridStreamOperationThree() throws IOException {
        // Set line number of the first fable
        int lineOfTheFirstFable = 1;

        // Set fable number
        int n = 290;

        // Provide fileName to be read for fables content
        String pathName = "files/aesops-compressed.bin";

        // New file reference for fables content
        File file = new File(pathName);

        // Get the size of the fable file
        int size = (int) Files.size(Paths.get(pathName));

        // Create inputStream over fileInputStream
        // Wrap bufferedInputStream over inputStream
        try (InputStream inputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {

            // Set maximum limit of bytes to be read
            bufferedInputStream.mark(size + 1);

            // Wrap inputStreamReader over bufferedInputStream
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);

            // Wrap lineNumberReader over inputStreamReader
            LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);

            // Read line
            lineNumberReader.readLine();

            // Iterate until correct fable number is retrieved
            while (lineNumberReader.getLineNumber() < n + lineOfTheFirstFable) {
                // Read line
                lineNumberReader.readLine();
            }

            // Get the fable data from lineNumberReader
            String fableData = lineNumberReader.readLine();

            // Print fable data
            System.out.println(fableData);

            // Extract offset, length, title, from read line
            int offset = Integer.parseInt(fableData.substring(0, 7).trim());
            int length = Integer.parseInt(fableData.substring(9, 16).trim());
            String title = fableData.substring(16);

            // Print the extracted information
            System.out.printf("%d %d %s\n", offset, length, title);

            // Reset bufferedInputStream
            bufferedInputStream.reset();

            // Set skip bytes from offset value
            int skip = (int) bufferedInputStream.skip(offset);

            // Set the skip value in totalSkip
            int totalSkip = skip;

            // Iterate with the skip value until less than offset value
            while (totalSkip < offset) {
                // Update skip and total skip value
                skip = (int) bufferedInputStream.skip(offset - totalSkip);
                totalSkip += skip;
            }

            // Initialize byte array
            byte[] bytes = new byte[4096];

            // Read bytes through bufferedInputStream
            int read = bufferedInputStream.read(bytes);

            // Create byteArrayInputStream
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes, 0, length);

            // Wrap gzipInputStream over byteArrayInputStream
            GZIPInputStream gzipInputStream = new GZIPInputStream(byteArrayInputStream);

            // Initialize bytes array to hold decompressed bytes
            byte[] bytes1 = new byte[4096];

            // Get size of decompressed bytes read
            int bytesDecompressed = gzipInputStream.read(bytes1);

            // Convert the bytes read into String
            String fableText = new String(bytes1, 0, bytesDecompressed);

            // Print the content
            System.out.println(fableText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
