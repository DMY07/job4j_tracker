package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public int multiply(int a) {
        return x * a;
    }

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int r) {
        return r - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int l) {
        return multiply(l) + sum(l) + minus(l) + divide(l);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(3);
        System.out.println("Multiply result: " + result);
        result = calculator.sum(7);
        System.out.println("Sum result: " + result);
        result = calculator.minus(12);
        System.out.println("Minus result: " + result);
        result = calculator.divide(99);
        System.out.println("Divide result: " + result);
        result = calculator.sumAllOperation(2);
        System.out.println("Sum of all operations: " + result);
    }
}
