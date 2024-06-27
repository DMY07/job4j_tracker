package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс представляет собой модель банковского счета
 * @author Dmitry
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета
     * Баланс счета
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор для создания банковского счета
     *
     * @param requisite реквизиты счета
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * метод возвращает реквизиты счета
     *
     * @return реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод устанавливает реквизиты счета
     *
     * @param requisite реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает баланс счета
     *
     * @return баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * метод устанавливает баланс счета
     *
     * @param balance баланс счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * метод проверяет равенство двух счетов по реквизитам
     *
     * @param o объект для сравнения
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * метод для возвращения хэш-код счета, основанный на реквизитах
     *
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
