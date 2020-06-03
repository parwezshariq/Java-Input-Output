package com.shariqparwez.io;

import com.shariqparwez.io.model.Person;
import com.shariqparwez.io.model.PersonCS;
import com.shariqparwez.io.model.PersonExt;
import com.shariqparwez.io.model.PersonOriginal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WritingDataObjects {
    public static void main(String[] args) {
        // ## 1 - Introducing serialization and the serialized file [S]
        //writingDataObjectsOperationOne();

        // ## 2 - Serializing a list of serializable objects [S]
        //writingDataObjectsOperationTwo();

        // ## 3 - Serializing person objects using writeObject [S]
        //writingDataObjectsOperationThree();

        // ## 4 - Serializing person objects using externalizable [S]
        //writingDataObjectsOperationFour();

        // ## 5 - Serializing person objects using a proxy class [S]
        writingDataObjectsOperationFive();
    }

    private static void writingDataObjectsOperationOne() {
        // Provide the name of file to store content of serialized object
        String fileName = "files/person.bin";

        // Create a new file object using the filename of binary file
        File file = new File(fileName);

        // Initialize two person objects to be serialized and store into binary file
        Person personOne = new Person("Linda", 32);
        Person personTwo = new Person("David", 27);

        // Create outputStream by using fileOutputStream created through file object
        // Wrap objectOutputStream over outputStream
        try (OutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {

            // Write both person objects into binary file
            objectOutputStream.writeObject(personOne);
            objectOutputStream.writeObject(personTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Print the size of the binary file created
            System.out.println("person.bin: " + Files.size(Paths.get(fileName)));
        } catch (IOException e) {}
    }

    private static void writingDataObjectsOperationTwo() {
        // Provide the name of file to store content of serialized object
        String fileName = "files/person.bin";

        // Create a new file object using the filename of binary file
        File file = new File(fileName);

        // Initialize two person objects to be serialized and store into binary file
        Person personOne = new Person("Linda", 32);
        Person personTwo = new Person("David", 27);

        // Create a list of person, and add person objects
        List<Person> personList = new ArrayList<>();
        personList.add(personOne);
        personList.add(personTwo);

        // Create outputStream by using fileOutputStream created through file object
        // Wrap objectOutputStream over outputStream
        try (OutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {

            // Write list of person into binary file
            objectOutputStream.writeObject(personList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Print the size of the binary file created
            System.out.println("person.bin: " + Files.size(Paths.get(fileName)));
        } catch (IOException e) {}
    }

    private static void writingDataObjectsOperationThree() {
        // Provide the name of file to store content of serialized object
        String fileName = "files/person-write-object.bin";

        // Create a new file object using the filename of binary file
        File file = new File(fileName);

        // Initialize two person objects to be serialized and store into binary file
        PersonCS personOne = new PersonCS("Linda", 32);
        PersonCS personTwo = new PersonCS("David", 27);

        // Create outputStream by using fileOutputStream created through file object
        // Wrap objectOutputStream over outputStream
        try (OutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {

            // Write both person objects into binary file
            objectOutputStream.writeObject(personOne);
            objectOutputStream.writeObject(personTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Print the size of the binary file created
            System.out.println("person.bin: " + Files.size(Paths.get(fileName)));
        } catch (IOException e) {}
    }

    private static void writingDataObjectsOperationFour() {
        // Provide the name of file to store content of serialized object
        String fileName = "files/person-externalizable.bin";

        // Create a new file object using the filename of binary file
        File file = new File(fileName);

        // Initialize two person objects to be serialized and store into binary file
        PersonExt personOne = new PersonExt("Linda", 32);
        PersonExt personTwo = new PersonExt("David", 27);

        // Create outputStream by using fileOutputStream created through file object
        // Wrap objectOutputStream over outputStream
        try (OutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {

            // Write both person objects into binary file
            objectOutputStream.writeObject(personOne);
            objectOutputStream.writeObject(personTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Print the size of the binary file created
            System.out.println("person.bin: " + Files.size(Paths.get(fileName)));
        } catch (IOException e) {}
    }

    private static void writingDataObjectsOperationFive() {
        // Provide the name of file to store content of serialized object
        String fileName = "files/person-proxy.bin";

        // Create a new file object using the filename of binary file
        File file = new File(fileName);

        // Initialize two person objects to be serialized and store into binary file
        PersonOriginal personOne = new PersonOriginal("Linda", 32);
        PersonOriginal personTwo = new PersonOriginal("David", 27);

        // Create outputStream by using fileOutputStream created through file object
        // Wrap objectOutputStream over outputStream
        try (OutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {

            // Write both person objects into binary file
            objectOutputStream.writeObject(personOne);
            objectOutputStream.writeObject(personTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Print the size of the binary file created
            System.out.println("person.bin: " + Files.size(Paths.get(fileName)));
        } catch (IOException e) {}
    }
}
