package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book encyclopedia = new Book("encyclopedia", 456);
        Book drama = new Book("drama", 1000);
        Book cleancode = new Book("Clean code", 99);
        Book cookbook = new Book("cookbook", 100);
        Book[] books = new Book[4];
        books[0] = encyclopedia;
        books[1] = drama;
        books[2] = cleancode;
        books[3] = cookbook;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " стр. " + book.getCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Перестановка местами");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " стр. " + book.getCount());
        }
        System.out.println("Книга с именем 'Clean code':");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " стр. " + book.getCount());
            }
        }
    }
}
