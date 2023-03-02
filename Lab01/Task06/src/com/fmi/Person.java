package com.fmi;

public class Person {

    private String name;
    private int age;

    public Person() {
        this.name = "No name";
        this.age = -1;
    }

    public Person(String name) {
        this.name = name;
        this.age = -1;
    }

    public Person(String name, int age) {
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
    public String toString() {

        if (name.equals("No name")) {
            return "Hello, I am John Doe. I am " + age + "years old.";
        } else if (age == -1) {
            return "Hello, I am " + name;
        }

        return "Hello, I am " + name + ". I am " + age + "years old.";
    }
}
