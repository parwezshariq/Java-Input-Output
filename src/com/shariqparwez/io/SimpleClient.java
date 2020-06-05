package com.shariqparwez.io;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        // ## 1 - Setting up a server that sends a text message [S]
        simpleClientOperationOne();
    }

    private static void simpleClientOperationOne() throws IOException {
        // Get socket object
        Socket socket = new Socket();

        // Provide hostname and port through InetSocketAddress
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 12345);

        // Connect socket
        socket.connect(address);

        // Get outputStream through socket
        OutputStream outputStream = socket.getOutputStream();

        // Wrap printWriter over outputStreamWriter
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));

        // Print message
        printWriter.println("list-fruits");

        // Flush the byte stream
        printWriter.flush();

        // Get the inputStream from socket
        InputStream inputStream = socket.getInputStream();

        // Wrap lineNumberReader over inputStreamReader
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream));

        // Fetch number of lines
        int number = Integer.parseInt(lineNumberReader.readLine());

        for (int i=0; i < number; i++) {
            // Read line by line
            String fruit = lineNumberReader.readLine();

            // Print result
            System.out.println(fruit);
        }

        // Close socket
        socket.close();
    }
}
