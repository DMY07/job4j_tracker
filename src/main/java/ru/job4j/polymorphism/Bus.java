package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус проехал");
    }

    @Override
    public void passengers(int number) {
        System.out.println("количество пассажиров: " + number);
    }

    @Override
    public void fuel(int amount) {
        double pricePerUnit = 55.0;
        double cost = amount * pricePerUnit;
        System.out.println("Заправка " + amount + " количество бензина. Общая стоимость: " + cost);
    }
}
