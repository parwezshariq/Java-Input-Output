package com.shariqparwez.io;

import com.shariqparwez.io.model.Person;
import com.shariqparwez.io.model.PersonCS;
import com.shariqparwez.io.model.PersonExt;
import com.shariqparwez.io.model.PersonOriginal;

import java.io.*;
import java.util.List;

public class ReadingDataObjects {
    public static void main(String[] args) {
        // ## 1 - Deserializing a list of person objects [S]
        //readingDataObjectsOperationOne();

        // ## 2 - Deserializing person object using readObject [S]
        //readingDataObjectsOperationTwo();

        // ## 3 - Deserializing externalized person object [S]
        //readingDataObjectsOperationThree();

        // ## 4 - Deserializing person object serialized with a proxy [S]
        readingDataObjectsOperationFour();
    }

    private static void readingDataObjectsOperationOne() {
        // Provide fileName along with path for the file to be read
        String fileName = "files/person.bin";

        // Build a new file object using fileName
        File file = new File(fileName);

        // Create InputStream, using FileInputStream created from file object
        // Wrap ObjectInputStream over InputStream object
        try (InputStream inputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            // Read and get list of person from binary file
            @SuppressWarnings("unchecked")
            List<Person> personList = (List<Person>) objectInputStream.readObject();

            // Print list of person fetched from binary file
            personList.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readingDataObjectsOperationTwo() {
        // Provide fileName along with path for the file to be read
        String fileName = "files/person-write-object.bin";

        // Build a new file object using fileName
        File file = new File(fileName);

        // Create InputStream, using FileInputStream created from file object
        // Wrap ObjectInputStream over InputStream object
        try (InputStream inputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            PersonCS personOne = (PersonCS) objectInputStream.readObject();
            System.out.println(personOne);
            PersonCS personTwo = (PersonCS) objectInputStream.readObject();
            System.out.println(personTwo);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readingDataObjectsOperationThree() {
        // Provide fileName along with path for the file to be read
        String fileName = "files/person-externalizable.bin";

        // Build a new file object using fileName
        File file = new File(fileName);

        // Create InputStream, using FileInputStream created from file object
        // Wrap ObjectInputStream over InputStream object
        try (InputStream inputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            PersonExt personOne = (PersonExt) objectInputStream.readObject();
            System.out.println(personOne);
            PersonExt personTwo = (PersonExt) objectInputStream.readObject();
            System.out.println(personTwo);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readingDataObjectsOperationFour() {
        // Provide fileName along with path for the file to be read
        String fileName = "files/person-proxy.bin";

        // Build a new file object using fileName
        File file = new File(fileName);

        // Create InputStream, using FileInputStream created from file object
        // Wrap ObjectInputStream over InputStream object
        try (InputStream inputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            PersonOriginal personOne = (PersonOriginal) objectInputStream.readObject();
            System.out.println(personOne);
            PersonOriginal personTwo = (PersonOriginal) objectInputStream.readObject();
            System.out.println(personTwo);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
