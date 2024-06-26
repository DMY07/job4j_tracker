package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemAscByNameTest {
    @Test
    public void whenSortByNameAsc() {
        List<Item> items = Arrays.asList(
                new Item(1, "Roma"),
                new Item(2, "Ivan"),
                new Item(3, "Egor")
        );
        List<Item> expected = Arrays.asList(
                new Item(3, "Egor"),
                new Item(2, "Ivan"),
                new Item(1, "Roma")
        );
        Collections.sort(items, new ItemAscByName());
        assertEquals(expected, items);
    }
}
