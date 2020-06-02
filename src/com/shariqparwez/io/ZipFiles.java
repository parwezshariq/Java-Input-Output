package com.shariqparwez.io;

import java.io.*;
import java.util.stream.IntStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFiles {
    public static void main(String[] args) {
        // ## 1 - Creating an archive file with the ZipOutputStream [S]
        zipFilesOperationOne();
    }

    private static void zipFilesOperationOne() {
        // Provide filename for archived file
        String fileName = "files/archive.zip";

        // Create OutputStream object using File object
        // Wrap ZipOutputStream over OutputStream
        // Wrap DataOutputStream over ZipOutputStream
        try (OutputStream outputStream = new FileOutputStream(new File(fileName));
             ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
             DataOutputStream dataOutputStream = new DataOutputStream(zipOutputStream);) {

            // Create and put zipEntry as next entry
            ZipEntry dirEntry = new ZipEntry("bin/");
            zipOutputStream.putNextEntry(dirEntry);

            // Create and put zipEntry as next entry
            ZipEntry binFileEntry = new ZipEntry("bin/ints.bin");
            zipOutputStream.putNextEntry(binFileEntry);

            // Write to binary file added in bin folder of zip file
            IntStream.range(0, 1000).forEach(i -> {
                try {
                    dataOutputStream.writeInt(i);
                } catch (IOException e) {

                }
            });

            // Create and put zipEntry as next entry
            ZipEntry otherDirEntry = new ZipEntry("text/");
            zipOutputStream.putNextEntry(otherDirEntry);

            // Create and put zipEntry as next entry
            ZipEntry textFileEntry = new ZipEntry("text/file.txt");
            zipOutputStream.putNextEntry(textFileEntry);

            // Write text entry into file added in text folder of zip file
            dataOutputStream.writeUTF("This is some text content");

        } catch (IOException e) {
        }
    }
}
