package ru.job4j.checkstyle;

public class Broken {
    public static final String NEWVALUE = "";
    private int sizeOfEmpty = 10;
    private String name;
    public String surname;

    Broken(int v) {
    }

    void echo() {
    }

    void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    void method(int a) {
    }
}