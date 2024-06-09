package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            if (matches < 1 || matches > 3) {
                System.out.println("Ошибка: можно ввести только число от 1 до 3. Попробуйте снова.");
            }
            if (matches > count) {
                System.out.println("Ошибка: нельзя взять больше оставшихся спичек. Попробуйте снова.");
            }
            count -= matches;
            System.out.println("Осталось спичек: " + count);

        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
