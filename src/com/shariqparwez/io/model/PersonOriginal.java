package com.shariqparwez.io.model;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class PersonOriginal implements Serializable {

    private String name;
    private int age;

    public PersonOriginal() {
    }

    public PersonOriginal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new PersonProxy(name + "::" + age);
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
