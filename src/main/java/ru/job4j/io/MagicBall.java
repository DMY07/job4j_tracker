package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {

    private static final String[] answers = {"Да", "Нет", "Может быть"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        System.out.println("Ответ великого Оракула:  " + answers[answer]);
    }
}
