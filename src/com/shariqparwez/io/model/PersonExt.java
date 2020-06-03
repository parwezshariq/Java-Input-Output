package com.shariqparwez.io.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PersonExt implements Externalizable {
    private String name;
    private int age;

    public PersonExt() {
    }

    public PersonExt(String name, int age) {
        this.name = name;
        this.age = age;
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
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        String primaryKey = name + "::" + age;
        objectOutput.write(primaryKey.getBytes());
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        byte[] buffer = new byte[1024];

        int read = objectInput.read(buffer);

        String content = new String(buffer, 0, read);

        String[] strings = content.split("::");

        this.name = strings[0];
        this.age = Integer.parseInt(strings[1]);
    }
}
