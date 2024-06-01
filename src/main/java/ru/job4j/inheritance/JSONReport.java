package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        return "{" + System.lineSeparator()
                + "\t\"name1\" : \"" + name + "\"," + System.lineSeparator()
                + "\t\"body1\" : \"" + body + "\"" + System.lineSeparator()
                + "}";
    }
}
