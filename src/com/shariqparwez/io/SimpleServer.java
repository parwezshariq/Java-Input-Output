package com.shariqparwez.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        // ## 1 - Setting up a server that sends a text message [S]
        simpleServerOperationOne();
    }

    private static void simpleServerOperationOne() throws IOException {
        // Create socket object
        ServerSocket serverSocket = new ServerSocket(12345);

        // Keep server up
        while (true) {
            // Let socket accept request
            System.out.println("I am waiting for requests");
            Socket accept = serverSocket.accept();
            System.out.println("We have a request!");

            // Get InputStream of socket
            InputStream inputStream = accept.getInputStream();

            // Wrap inputStreamReader over inputStream
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            // Wrap lineNumberReader over inputStreamReader
            LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);

            // Read message from request
            String request = lineNumberReader.readLine();

            // Print request
            System.out.println("Request = " + request);

            if (request.equals("list-fruits")) {
                // Get output stream of socket
                OutputStream outputStream = accept.getOutputStream();

                // Create outputStreamWriter
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

                // Wrap printWriter over outputStreamWriter
                PrintWriter printWriter = new PrintWriter(outputStreamWriter);

                // Print fruit list
                printWriter.println("3");
                printWriter.println("Apple");
                printWriter.println("Orange");
                printWriter.println("Banana");

                // Flush the content
                printWriter.flush();
            }
        }
    }
}
