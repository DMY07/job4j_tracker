package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс - сервис для работы с пользователями и их банковскими счетами
 *
 * @author Dmitry
 * @version 1.0
 */
public class BankService {
    /**
     * Карта пользователей и их банковских счетов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему
     *
     * @param user пользователь для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из системы по паспортным данным
     *
     * @param passport паспортные данные пользователя для удаления
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод обавляет банковский счет пользователю
     *
     * @param passport паспортные данные пользователя
     * @param account банковский счет для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод для поиска пользователя по паспортным данным
     *
     * @param passport паспортные данные пользователя
     * @return найденный пользователь или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод для поиска банковского счета по паспортным данным и реквизитам счета.
     *
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты счета
     * @return найденный счет или null, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод переводит деньги между счетами пользователей.
     *
     * @param sourcePassport паспортные данные отправителя
     * @param sourceRequisite реквизиты счета отправителя
     * @param destinationPassport паспортные данные получателя
     * @param destinationRequisite реквизиты счета получателя
     * @param amount сумма перевода
     * @return true, если перевод успешен, иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account srcAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * метод возвращает список счетов пользователя
     *
     * @param user пользователь
     * @return список счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
