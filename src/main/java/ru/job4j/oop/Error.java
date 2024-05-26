package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(true, 13, "Есть сообщение");
        error.printInfo();
        error1.printInfo();
    }

    public void printInfo() {
        System.out.println("boolean равно: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);

    }
}
