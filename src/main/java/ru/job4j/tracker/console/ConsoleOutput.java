package ru.job4j.tracker.console;

import ru.job4j.tracker.Output;

public class ConsoleOutput implements Output {
    @Override
    public void println(Object object) {
        System.out.println(object);
    }
}
/* n12 */