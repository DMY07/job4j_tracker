package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("dpl_info@mail.ru", "Дмитрий");
        map.put("test@mail.ru", "Василий");
        map.put("test1@mail.ru", "Григорий");
        map.put("ttt@mail.ru", "Егор");
        map.put("ttt@mail.ru", "Игорь");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}

