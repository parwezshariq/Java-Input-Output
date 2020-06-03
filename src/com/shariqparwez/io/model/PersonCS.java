package com.shariqparwez.io.model;

import java.io.*;

public class PersonCS implements Serializable {

    private transient String name;
    private transient int age;

    public PersonCS() {
    }

    public PersonCS(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Provide custom serialization
    private void writeObject(ObjectOutputStream objectOutputStream) throws Exception {
        // Wrap dataOutputStream over objectOutputStream
        DataOutputStream dataOutputStream = new DataOutputStream(objectOutputStream);

        // Serialized content to be persisted over stream
        dataOutputStream.writeUTF(name + "::" + age);
    }

    // Provide custom deserialization
    private void readObject(ObjectInputStream objectInputStream) throws Exception {
        // Wrap dataInputStream over objectInputStream
        DataInputStream dataInputStream = new DataInputStream(objectInputStream);

        // De-serialize content from stream stream
        String content = dataInputStream.readUTF();
        String[] strings = content.split("::");
        this.name = strings[0];
        this.age = Integer.parseInt(strings[1]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
