package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Элемент не найден");
    }

    public static void main(String[] args) {
        String[] array = {"ноль", "один", "два"};
        try {
            int index = indexOf(array, "ноль"); //
            System.out.println("ноль': " + index);
            index = indexOf(array, "один");
            System.out.println("один': " + index);
            index = indexOf(array, "три");
            System.out.println("три': " + index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
