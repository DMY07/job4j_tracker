package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс - модель пользователя банка
 *
 * @author Dmitry
 * @version 1.0
 */
public class User {
    /**
     * Паспортные данные пользователя
     */
    private String passport;
    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Конструктор для создания пользователя
     *
     * @param passport паспортные данные пользователя
     * @param username имя пользователя
     */

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает паспортные данные пользователя.
     *
     * @return паспортные данные
     */

    public String getPassport() {
        return passport;
    }

    /**
     * Метод устанавливает паспортные данные пользователя
     *
     * @param passport паспортные данные
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает имя пользователя
     *
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод устанавливает имя пользователя
     *
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод проверяет равенство двух пользователей по паспортным данным
     *
     * @param o это объект для сравнения
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод возвращает хэш-код пользователя, основанный на паспортных данных
     *
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
